package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理要实现的功能
 *
 * @author cy
 */
public class Aop implements InvocationHandler {

	/**
	 * 代理对象
	 */
	Object target;

	public Aop(Object o){
		this.target = o;
	}

	/**
	 *
	 * @param proxy 代理对象
	 * @param method 代理方法
	 * @param args 参数
	 * @return obj
	 * @throws Throwable  Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("jdk dynamic before");
		Object object = method.invoke(target, args);
		System.out.println("jdk dynamic after");
		return object;
	}
}
