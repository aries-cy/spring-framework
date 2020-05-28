package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * 实现cglib工厂
 *
 * @author cy
 */
public class CglibObjectFactory {


	public static <T> T getProxiedObject(Class clazz){
		Enhancer enhancer = new Enhancer();
		//设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(new Aop2());
		T proxied = (T) enhancer.create();

		return proxied;
	}
}
