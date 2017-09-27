package org.rpc.qrpc.mode.proxy.stati;

public class StaticProxyMain {

	public static void main(String[] args) {
		
		AbstractSubject subject = new ProxySubject();
		subject.request();
	}
}
