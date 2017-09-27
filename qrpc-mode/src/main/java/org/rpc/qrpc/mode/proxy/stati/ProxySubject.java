package org.rpc.qrpc.mode.proxy.stati;

public class ProxySubject extends AbstractSubject{

	private AbstractSubject subject;
	@Override
	public void request() {
		// TODO Auto-generated method stub
		beforeRequest();
		if(null==subject){
			subject = new RealSubject();
		}
		subject.request();
		afterRequest();
	}
	
	public void beforeRequest(){
		System.out.println("方法执行前===");
	}
	public void afterRequest(){
		System.out.println("方法执行后===");
	}

}
