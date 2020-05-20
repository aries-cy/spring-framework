package importselector.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * TODO 描述
 *
 * @author cy
 */
public class Dog implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("前置处理方法...");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("后置处理方法...");
		return null;
	}

	public void test(){
		System.out.println("哈哈哈");
	}
}
