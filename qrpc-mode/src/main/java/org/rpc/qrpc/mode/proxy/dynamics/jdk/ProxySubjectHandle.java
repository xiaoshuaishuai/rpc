package org.rpc.qrpc.mode.proxy.dynamics.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubjectHandle implements InvocationHandler {
	private Object target;

	public ProxySubjectHandle(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("request".equals(method.getName())) {
			beforeRequest();
			Object result = method.invoke(target, args);
			afterRequest();
			return result;
		} else {
			Object result = method.invoke(target, args);
			return result;
		}
	}

	public void beforeRequest() {
		System.out.println("方法执行前===");
	}

	public void afterRequest() {
		System.out.println("方法执行后===");
	}
}
