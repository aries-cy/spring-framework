package beanfactorypostprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义的 beanFactoryPostProcessor
 * 任意bean实例化之前执行，针对beanFactory来建设。经典案例：configurationClassPostProcessor，针对配置类加上cglib代理
 *
 * @author cy
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private static final String REMARK = "remark";

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("第一步：invoke MyBeanFactoryPostProcessor.postProcessBeanFactory 方法...");
		BeanDefinition benzCarBeanDefinition = beanFactory.getBeanDefinition("benzCar");
		//属性
		MutablePropertyValues propertyValues = benzCarBeanDefinition.getPropertyValues();
		//会调用bean中的set方法
		propertyValues.add("remark","初始化添加remark");
		propertyValues.add("desc","初始化添加desc");
		if(propertyValues.contains(REMARK)){
			propertyValues.addPropertyValue(REMARK,"在BeanFactoryPostProcessor中修改之后的备忘信息");
		}
	}
}
