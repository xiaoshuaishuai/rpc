package org.rpc.qrpc.schema.support;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class QrpcNamespaceHandlerSupport extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("service", new QrpcBeanDefinitionParser(ServiceConfig.class));
	}

}
