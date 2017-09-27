package org.rpc.qrpc.schema;
import org.rpc.qrpc.schema.support.ServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ServiceConfig service = (ServiceConfig) context.getBean("rpcService");
		
		System.out.println(service.toString());
	}
}
