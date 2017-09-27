package org.rpc.qrpc.mode.proxy.dynamics.cglib;

public class CglibMain {

	public static void main(String[] args) {
		CglibMethodProxy cglib = new CglibMethodProxy();
		DbService service = (DbService) cglib.createProxy(new DbService());
		service.db();
		
		service.del();
	}
}
