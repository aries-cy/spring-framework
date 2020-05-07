package beanfactorypostprocessor;

import beanfactorypostprocessor.config.MyConfiguration;
import beanfactorypostprocessor.model.BenzCar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * beanFactoryPostProcessor测试类
 * beanFactoryPostProcessor提供了beanFactory，可以修改、添加bean的一些属性
 * 任意bean实例化之前执行，针对beanFactory来建设。经典案例：configurationClassPostProcessor，针对配置类加上cglib代理
 *
 * @author cy
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		BenzCar benzCar = (BenzCar) context.getBean("benzCar");
		System.out.println(benzCar);
	}
}
