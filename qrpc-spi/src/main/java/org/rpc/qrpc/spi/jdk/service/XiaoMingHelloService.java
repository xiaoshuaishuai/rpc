package org.rpc.qrpc.spi.jdk.service;

public class XiaoMingHelloService implements IHelloService {
	public void sayHello(String msg) {
		System.out.println("小明说:" + msg);
	}

}
