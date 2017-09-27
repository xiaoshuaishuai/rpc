package org.rpc.qrpc.mode.proxy.classloader;

public class MyClassloader extends ClassLoader {

	public Class<?> defineCls( byte[] b, int off, int len)   
    {  
        return super.defineClass(b, off, len);  
    }  
}
