package org.rpc.qrpc.transport.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcInvoker {
	private static ExecutorService executorService = Executors.newFixedThreadPool(20);

	// 暴露服务
	/**
	 * @param service
	 *            服务实现类
	 * @param port
	 *            服务端口
	 * @throws IOException
	 */
	public static void export(final Object service, int port) throws IOException {
		System.out.println("export service :" + service.getClass().getName() + ",port:" + port);
		final ServerSocket server = new ServerSocket(port);
		while (true) {
            final Socket socket = server.accept();
			executorService.execute(new Runnable() {
				ObjectInputStream input = null;
				ObjectOutputStream output = null;
				public void run() {
					try {
						input = new ObjectInputStream(socket.getInputStream());
						output = new ObjectOutputStream(socket.getOutputStream());
						// *********************************************************************
						String methodName = input.readUTF();// 方法名称
						Class<?>[] parameterTypes = (Class<?>[]) input.readObject();// 参数类型
						Object[] args = (Object[]) input.readObject();// 参数
						// *********************************************************************

						// *********************************************************************
						Method method = service.getClass().getMethod(methodName, parameterTypes);
						Object object = method.invoke(service, args);
						output.writeObject(object);
						// *********************************************************************

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (null != output) {
							try {
								output.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (null != input) {
							try {
								input.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (null != socket) {
							try {
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}
			});
		}
	}

	// 调用服务
	@SuppressWarnings("unchecked")
	public static <T> T refer(Class<T> interfaceClass ,final String host, final int port) {
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
			Socket socket = null;
			ObjectInputStream input = null;
			ObjectOutputStream output = null;
			Object result = null;
			public Object invoke(Object proxy, Method method, Object[] args) {
				try {
					Socket socket = new Socket(host, port);
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
					//*********************************************************************
					output.writeUTF(method.getName());
					output.writeObject(method.getParameterTypes());
					output.writeObject(args);
					//*********************************************************************
					result = input.readObject();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
					
				finally {
					if (null != output) {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (null != input) {
						try {
							input.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (null != socket) {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				return result;
			}
		});
	}
}
