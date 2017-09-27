package org.rpc.qrpc.schema.support;

public class ServiceConfig {

	private String id;
	private String interfaceClass;
	private String version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInterfaceClass() {
		return interfaceClass;
	}
	public void setInterfaceClass(String interfaceClass) {
		this.interfaceClass = interfaceClass;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "ServiceConfig [id=" + id + ", interfaceClass=" + interfaceClass + ", version=" + version + "]";
	}
	
	
}
