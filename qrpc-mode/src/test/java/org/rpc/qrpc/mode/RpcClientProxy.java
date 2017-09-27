package org.rpc.qrpc.mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcClientProxy implements InvocationHandler{

	public Object target;
	
	
	public RpcClientProxy(Object target) {
		this.target = target;
	}
	//创建代理类 
	public Object createProxy(Object obj){
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        result = method.invoke(target,args);
        //在调用具体函数方法后，执行功能处理
        return result;

	}

}
