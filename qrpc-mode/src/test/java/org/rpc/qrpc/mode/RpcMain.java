package org.rpc.qrpc.mode;

public class RpcMain {

	public static void main(String[] args) {

		RpcClientProxy proxy = new RpcClientProxy(new HelloServiceImpl());
		HelloService service = (HelloService) proxy.createProxy(new HelloServiceImpl());
		service.hello();
	}
}
