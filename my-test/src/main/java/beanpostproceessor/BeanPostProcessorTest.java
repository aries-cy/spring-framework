package beanpostproceessor;

import beanpostproceessor.config.BeanPostProcessorConfig;
import beanpostproceessor.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanPostProcessor测试类
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
