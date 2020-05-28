package proxy.jdk;

import proxy.dao.TestDao;
import proxy.dao.impl.TestDaoImpl;

import java.lang.reflect.Proxy;

/**
 * 生成代理类的工厂
 *
 * @author cy
 */
public class JdkDynamicObjectFactory {

	public static <T> T getProxiedObject(Class clazz){

		Aop aop = null;
		try {
			aop = new Aop(clazz.newInstance());
			//JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
			T proxied = (T) Proxy.newProxyInstance(JdkDynamicObjectFactory.class.getClassLoader(), clazz.getInterfaces(), aop);
			return proxied;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
