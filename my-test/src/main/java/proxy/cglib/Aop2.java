package proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib也要实现接口
 *
 * @author cy
 */
public class Aop2 implements MethodInterceptor {


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib before");
		Object re = methodProxy.invokeSuper(o, objects);
		System.out.println("cglib after");
		return re;
	}
}
