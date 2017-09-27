package org.rpc.qrpc.mode.adapter.obj;

/**
 * 适配对象
 * 
 * @author shuaishuaixiao
 *
 */
public class Adapter implements Target{
	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	public void m3() {
		// TODO Auto-generated method stub
		adaptee.m3();
	}

	public void m4() {
		// TODO Auto-generated method stub
		System.out.println("Adapter.m4()适配对象执行====");
	}
	

}
