package uy.com.amensg.claro.dwr;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.claro.entities.Menu;
import uy.com.amensg.claro.entities.MenuTO;

@RemoteProxy
public class MenuDWR {

	public static MenuTO transform(Menu menu) {
		MenuTO menuTO = new MenuTO();
		
		menuTO.setOrden(menu.getOrden());
		menuTO.setTitulo(menu.getTitulo());
		menuTO.setUrl(menu.getUrl());
		
		menuTO.setFact(menu.getFact());
		menuTO.setId(menu.getId());
		menuTO.setTerm(menu.getTerm());
		menuTO.setUact(menu.getUact());
		
		return menuTO;
	}
}