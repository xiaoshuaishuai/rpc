package org.rpc.qrpc.transport.server;

import java.io.IOException;

import org.rpc.qrpc.transport.core.RpcInvoker;

public class RpcServer {

	public static void main(String[] args) {
		try {
			RpcInvoker.export(new HelloServiceImpl(), 6666);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
