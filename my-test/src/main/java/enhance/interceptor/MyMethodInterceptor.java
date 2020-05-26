package enhance.interceptor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 自定义的 MethodInterceptor
 *
 * @author cy
 */
public class  MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		/**
		 * 对方法进行拦截
		 */
		System.out.println("MyMethodInterceptor intercept...");
		return methodProxy.invokeSuper(o,objects);
	}
}
