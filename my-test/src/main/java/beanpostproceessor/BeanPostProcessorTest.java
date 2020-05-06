package beanpostproceessor;

import beanpostproceessor.config.BeanPostProcessorConfig;
import beanpostproceessor.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanPostProcessor测试类
 * 在bean实例化的前后执行特定的方法：before；after
 *
 *
 * @author cy
 */
public class BeanPostProcessorTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
		HelloService helloService = (HelloService) context.getBean("helloServiceImpl");
		helloService.sayHello();
	}
}
