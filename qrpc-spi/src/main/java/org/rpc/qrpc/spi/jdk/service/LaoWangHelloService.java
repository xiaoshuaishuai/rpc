package org.rpc.qrpc.spi.jdk.service;

public class LaoWangHelloService implements IHelloService{
	public void sayHello(String msg) {
		System.out.println("老王说:"+msg);
	}

}
