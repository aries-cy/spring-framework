package beanpostproceessor.proceessor;

import beanpostproceessor.service.NameInit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 针对继承了接口的bean，注入name
 *
 * @author cy
 */
@Component
public class NameBeanPostProcessor implements BeanPostProcessor {

	private String name = "哈哈哈";

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof NameInit){
			((NameInit)bean).setName(name);
		}
		System.out.println("正在处理："+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("已处理完成："+beanName);
		return bean;
	}

}
