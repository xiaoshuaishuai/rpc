package org.rpc.qrpc.transport.client;

import org.rpc.qrpc.transport.core.RpcInvoker;
import org.rpc.qrpc.transport.interfac.IHelloService;

public class RpcClient {

	public static void main(String[] args) throws InterruptedException {

		IHelloService helloService = RpcInvoker.refer(IHelloService.class, "localhost", 6666);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println(helloService.say(i + ""));
			System.out.println(helloService.haha(i + ""));
			Thread.sleep(500);
		}
	}
}
