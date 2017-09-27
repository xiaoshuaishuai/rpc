package org.rpc.qrpc.transport.server;

import org.rpc.qrpc.transport.interfac.IHelloService;

public class HelloServiceImpl implements IHelloService {

	public String say(String msg) {
		return "say:"+msg;
	}

	public String haha(String msg) {
		return msg;
	}

}
