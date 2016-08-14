package uy.com.amensg.claro.bean;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import uy.com.amensg.claro.entities.ClaroInterfaceContrato;
import uy.com.amensg.claro.entities.ClaroInterfaceEstado;
import uy.com.amensg.claro.entities.ClaroInterfaceNim;
import uy.com.amensg.claro.entities.ClaroInterfaceProceso;
import uy.com.amensg.claro.entities.Empresa;
import uy.com.amensg.claro.entities.MetadataCondicion;
import uy.com.amensg.claro.entities.MetadataConsulta;
import uy.com.amensg.claro.entities.MetadataConsultaResultado;
import uy.com.amensg.claro.entities.MetadataOrdenacion;
import uy.com.amensg.claro.util.Configuration;
import uy.com.amensg.claro.util.Constants;
import uy.com.amensg.claro.util.QueryHelper;

@Stateless
public class ClaroInterfaceContratoBean implements IClaroInterfaceContratoBean {

	@PersistenceContext(unitName = "uy.com.amensg.claro.persistenceUnit")
	private EntityManager entityManager;

	@EJB
	private IClaroInterfaceProcesoBean iClaroInterfaceProcesoBean;
	
	private CriteriaQuery<ClaroInterfaceContrato> criteriaQuery;
	
	public Collection<ClaroInterfaceContrato> list() {
		Collection<ClaroInterfaceContrato> result = new LinkedList<ClaroInterfaceContrato>();
		
		try {
			Query query = entityManager.createQuery("SELECT c FROM ClaroInterfaceContrato c");
			
			for (Object object : query.getResultList()) {
				result.add((ClaroInterfaceContrato) object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public MetadataConsultaResultado list(MetadataConsulta metadataConsulta) {
		MetadataConsultaResultado result = new MetadataConsultaResultado();
		
		try {
			// Query para obtener los registros de muestra
			TypedQuery<ClaroInterfaceContrato> queryMuestra = this.construirQuery(metadataConsulta);
			queryMuestra.setMaxResults(metadataConsulta.getTamanoMuestra().intValue());
			
			Collection<Object> registrosMuestra = new LinkedList<Object>();
			for (ClaroInterfaceContrato claroInterfaceContrato : queryMuestra.getResultList()) {
				registrosMuestra.add(claroInterfaceContrato);
			}
			
			result.setRegistrosMuestra(registrosMuestra);
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			
			// Query para obtener la cantidad de registros
			CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);
			
			criteriaQueryCount.select(
				criteriaBuilder.count(criteriaQueryCount.from(ClaroInterfaceContrato.class))
			);
			
			criteriaQueryCount.where(criteriaQuery.getRestriction());
			
			TypedQuery<Long> queryCount = entityManager.createQuery(criteriaQueryCount);
			
			for (Parameter<?> parameter : queryMuestra.getParameters()) {
				queryCount.setParameter(parameter.getName(), queryMuestra.getParameterValue(parameter));
			}
			
			result.setCantidadRegistros(queryCount.getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MetadataConsultaResultado list(MetadataConsulta metadataConsulta, Long loggedUsuarioId) {
		return this.list(metadataConsulta);
	}
	
	public String preprocesarExportacion(MetadataConsulta metadataConsulta, Empresa empresa) {
		return null;
	}

	public String exportarAExcel(MetadataConsulta metadataConsulta, Long loggedUsuarioId) {
		String result = null;
		
		try {
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			
			String fileName = 
				gregorianCalendar.get(GregorianCalendar.YEAR) + ""
				+ (gregorianCalendar.get(GregorianCalendar.MONTH) + 1) + ""
				+ gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH) + ""
				+ gregorianCalendar.get(GregorianCalendar.HOUR_OF_DAY) + ""
				+ gregorianCalendar.get(GregorianCalendar.MINUTE) + ""
				+ gregorianCalendar.get(GregorianCalendar.SECOND)
				+ ".csv";
			
			PrintWriter printWriter = 
				new PrintWriter(
					new FileWriter(
						Configuration.getInstance().getProperty("exportacion.carpeta") + fileName
					)
				);
			
			printWriter.println(
				"NIM"
				+ ";Obtenido"
			);
			
			metadataConsulta.setTamanoMuestra(new Long(Integer.MAX_VALUE));
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			for (Object object : this.list(metadataConsulta, loggedUsuarioId).getRegistrosMuestra()) {
				ClaroInterfaceContrato contrato = (ClaroInterfaceContrato) object;
				
				String line = 
					contrato.getNim()
					+ ";" + (contrato.getFact() != null ? 
						format.format(contrato.getFact())
						: "");
				
				printWriter.println(line.replaceAll("\n", ""));
			}
			
			printWriter.close();
			
			result = fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String exportarAExcel(MetadataConsulta metadataConsulta, Empresa empresa, String observaciones) {
		return null;
	}

	public void reprocesar(MetadataConsulta metadataConsulta, String observaciones) {
		try {
			Date hoy = GregorianCalendar.getInstance().getTime();
			
			ClaroInterfaceProceso claroInterfaceProceso = new ClaroInterfaceProceso();
			claroInterfaceProceso.setFechaInicio(hoy);
			claroInterfaceProceso.setObservaciones(observaciones);
			
			claroInterfaceProceso.setUact(new Long(1));
			claroInterfaceProceso.setFact(hoy);
			claroInterfaceProceso.setTerm(new Long(1));
			
			claroInterfaceProceso = iClaroInterfaceProcesoBean.save(claroInterfaceProceso);
			
			ClaroInterfaceEstado estado = 
				entityManager.find(ClaroInterfaceEstado.class, new Long(Configuration.getInstance().getProperty("claroInterfaceEstado.ParaProcesarPrioritario")));
			
			for (ClaroInterfaceContrato claroInterfaceContrato : this.listSubconjunto(metadataConsulta)) {
				ClaroInterfaceNim claroInterfaceNim = new ClaroInterfaceNim();
				claroInterfaceNim.setNim(claroInterfaceContrato.getNim());
				claroInterfaceNim.setProcesoId(claroInterfaceProceso.getId());
				
				claroInterfaceNim.setEstado(estado);
				
				claroInterfaceNim.setUact(new Long(1));
				claroInterfaceNim.setFact(hoy);
				claroInterfaceNim.setTerm(new Long(1));
				
				entityManager.merge(claroInterfaceNim);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private TypedQuery<ClaroInterfaceContrato> construirQuery(MetadataConsulta metadataConsulta) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		criteriaQuery = criteriaBuilder.createQuery(ClaroInterfaceContrato.class);
		
		Root<ClaroInterfaceContrato> root = criteriaQuery.from(ClaroInterfaceContrato.class);
		
		List<Order> orders = new LinkedList<Order>();
		
		for (MetadataOrdenacion metadataOrdenacion : metadataConsulta.getMetadataOrdenaciones()) {
			if (metadataOrdenacion.getAscendente()) {
				orders.add(criteriaBuilder.asc(root.get(metadataOrdenacion.getCampo())));
			} else {
				orders.add(criteriaBuilder.desc(root.get(metadataOrdenacion.getCampo())));
			}
		}
		
		criteriaQuery
			.select(root)
			.orderBy(orders)
			.where(new QueryHelper().construirWhere(metadataConsulta, criteriaBuilder, root));
		
		TypedQuery<ClaroInterfaceContrato> query = entityManager.createQuery(criteriaQuery);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		int i = 0;
		for (MetadataCondicion metadataCondicion : metadataConsulta.getMetadataCondiciones()) {
			if (!metadataCondicion.getOperador().equals(Constants.__METADATA_CONDICION_OPERADOR_INCLUIDO)) {
				for (String valor : metadataCondicion.getValores()) {
					Path<?> campo = root.get(metadataCondicion.getCampo());
					
					try {
						if (campo.getJavaType().equals(Date.class)) {
							query.setParameter(
								"p" + i,
								format.parse(valor)
							);
						} else if (campo.getJavaType().equals(Long.class)) {
							query.setParameter(
								"p" + i,
								new Long(valor)
							);
						} else if (campo.getJavaType().equals(String.class)) {
							query.setParameter(
								"p" + i,
								valor
							);
						} else if (campo.getJavaType().equals(Double.class)) {
							query.setParameter(
								"p" + i,
								new Double(valor)
							);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					i++;
				}
				
				if (metadataCondicion.getValores().size() == 0) {
					i++;
				}
			}
		}
		
		return query;
	}

	private Collection<ClaroInterfaceContrato> listSubconjunto(MetadataConsulta metadataConsulta) {
		Collection<ClaroInterfaceContrato> resultList = new LinkedList<ClaroInterfaceContrato>();
		
		TypedQuery<ClaroInterfaceContrato> query = this.construirQuery(metadataConsulta);
		
		if (metadataConsulta.getTamanoSubconjunto() != null) {
			List<ClaroInterfaceContrato> toOrder = query.getResultList();
			
			Collections.shuffle(toOrder);
			
			int i = 0;
			for (ClaroInterfaceContrato claroInterfaceContrato : toOrder) {
				resultList.add(claroInterfaceContrato);
				
				i++;
				if (i == metadataConsulta.getTamanoSubconjunto()) {
					break;
				}
			}
		} else {
			resultList = query.getResultList();
		}
		
		return resultList;
	}
}