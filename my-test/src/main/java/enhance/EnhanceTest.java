package enhance;

import enhance.config.EnhanceConfiguration;
import enhance.interceptor.MyMethodInterceptor;
import enhance.model.IndexDao1;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * enhance测试类
 *
 * @author cy
 */
public class EnhanceTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnhanceConfiguration.class);

		EnhanceConfiguration enhanceConfiguration = (EnhanceConfiguration) context.getBean("enhanceConfiguration");

		/**
		 * EnhanceConfiguration 加了 @Configuration	,spring为其产生了 cglib 代理 ，实现了 BeanFactoryAware 接口
		 * BeanFactoryAware 中的 setBeanFactory 方法 为其设置了 $$beanFactory 成员变量
		 */
		if(enhanceConfiguration instanceof BeanFactoryAware){
			System.out.println("哈哈哈哈");
		}

		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(IndexDao1.class);

		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);

		/**
		 * 对方法进行拦截
		 */
		enhancer.setCallback(new MyMethodInterceptor());

		IndexDao1 indexDao1 = (IndexDao1) enhancer.create();

		indexDao1.sayHello();

	}


}
