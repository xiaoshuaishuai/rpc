package org.rpc.qrpc.mode.proxy.dynamics.jdk;

import java.lang.reflect.Proxy;

public class DynamicsMain {

	public static void main(String[] args) {
		Subject real = new RealSubject();
		
		ProxySubjectHandle invocationHandler = new ProxySubjectHandle(real);
		
		Subject proxy = (Subject) Proxy.newProxyInstance(real.getClass().getClassLoader(),
				real.getClass().getInterfaces(), invocationHandler);
		
		proxy.request();
	}
}
