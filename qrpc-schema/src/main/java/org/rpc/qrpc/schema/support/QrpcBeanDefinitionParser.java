package org.rpc.qrpc.schema.support;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class QrpcBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{

	private Class<?> cls;
	
	
	public QrpcBeanDefinitionParser(Class<?> cls) {
		this.cls = cls;
	}

	@Override
	protected Class<?> getBeanClass(Element element) {
		
		return cls;
	}
	
	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		if(cls.equals(ServiceConfig.class)){
			String id =element.getAttribute("id");
			String interfaceClass =element.getAttribute("interfaceClass");
			String version =element.getAttribute("version");
			
			if(StringUtils.hasText(id)){
				builder.addPropertyValue("id", id);
			}
			if(StringUtils.hasText(interfaceClass)){
				builder.addPropertyValue("interfaceClass", interfaceClass);
			}
			if(StringUtils.hasText(version)){
				builder.addPropertyValue("version", version);
			}
		}
	}
}
