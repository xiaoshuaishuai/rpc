package org.rpc.qrpc.spi.jdk.spi;

import java.util.ServiceLoader;

import org.rpc.qrpc.spi.jdk.service.IHelloService;
import org.rpc.qrpc.spi.jdk.service.LaoWangHelloService;

public class JdkSpiMain {

	public static void main(String[] args) {
		ServiceLoader<IHelloService> loader = ServiceLoader.load(IHelloService.class);
		
		for(IHelloService service :loader ){
			service.sayHello("=====");
		}
		
//		System.out.println(JdkSpiMain.class.getName());
//		System.out.println(JdkSpiMain.class.getSimpleName());
		
		System.out.println(JdkSpiMain.class.getResource(""));
		System.out.println(JdkSpiMain.class.getResource("/"));
		
		
		System.out.println(IHelloService.class.isAssignableFrom(LaoWangHelloService.class));
		System.out.println(IHelloService.class.isAssignableFrom(JdkSpiMain.class));
	}
}
