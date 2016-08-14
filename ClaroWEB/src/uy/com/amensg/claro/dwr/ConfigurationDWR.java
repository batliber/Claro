package uy.com.amensg.claro.dwr;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.amensg.claro.util.Configuration;

@RemoteProxy
public class ConfigurationDWR {

	public String getProperty(String name) {
		return Configuration.getInstance().getProperty(name);
	}
}