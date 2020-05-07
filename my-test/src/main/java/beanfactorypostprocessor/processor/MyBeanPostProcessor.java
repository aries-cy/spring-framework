package beanfactorypostprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义的BeanPostProcessor
 *
 * @author cy
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("6.BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("2.BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString());
		return bean;
	}
}
