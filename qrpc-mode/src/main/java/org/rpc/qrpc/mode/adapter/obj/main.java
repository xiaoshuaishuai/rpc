package org.rpc.qrpc.mode.adapter.obj;

public class main {

	public static void main(String[] args) {
		
		Adapter adapter = new Adapter(new Adaptee());
		adapter.m3();
		adapter.m4();
	}
}
