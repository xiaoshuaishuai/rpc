package org.rpc.qrpc.mode.proxy.dynamics.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibMethodProxy  implements MethodInterceptor{
	
	private Object target;
	/**
	 * 创建代理类
	 * @param target
	 * @return
	 */
	public Object createProxy(Object target){
		this.target =target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	/**
	 * 拦截
	 */
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("before------=======");
		Object o = proxy.invokeSuper(obj, args);
		System.out.println("after------=======");
		return o;
	}
}
