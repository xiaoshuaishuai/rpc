package org.rpc.qrpc.mode.proxy.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class Main {
	private static final String Cls = ".class";

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String url = "D:\\shuaishuai\\works\\workspace\\canal\\qrpc-mode\\target\\classes\\org\\rpc\\qrpc\\mode\\proxy\\classloader\\"+Programmer.class.getSimpleName()+Cls;
		System.out.println(url);
		File file = new File(url);
		byte[] bt = new byte[1024];
		InputStream is = new FileInputStream(file);
		int count  = is.read(bt);
		MyClassloader loader = new MyClassloader();
		
		Class<?> classes = loader.defineCls(bt, 0, count );
		
		System.out.println(classes.getName());
		System.out.println(classes.getCanonicalName());
		
		Object obj =  classes.newInstance();
		
		classes.getMethod("code", null).invoke(obj, null);
	}
}
