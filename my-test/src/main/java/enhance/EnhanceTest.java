package enhance;

import enhance.config.EnhanceConfiguration;
import enhance.interceptor.MyMethodInterceptor;
import enhance.model.IndexDao1;
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
