package proxy;

import proxy.cglib.CglibObjectFactory;
import proxy.dao.TestDao;
import proxy.dao.impl.TestDaoImpl;
import proxy.jdk.JdkDynamicObjectFactory;

/**
 * jdk动态代理：JDK动态代理只能对实现了接口的类生成代理，而不能针对类
 *
 * cglib动态代理：CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法
 *
 * @author cy
 */
public class ProxyTest {

	public static void main(String[] args) {
		TestDao cglibDao = CglibObjectFactory.getProxiedObject(TestDaoImpl.class);
		cglibDao.test();
		System.out.println("--------------分割线----------------");
		TestDao jdkDao = JdkDynamicObjectFactory.getProxiedObject(TestDaoImpl.class);
		jdkDao.test();
	}
}
