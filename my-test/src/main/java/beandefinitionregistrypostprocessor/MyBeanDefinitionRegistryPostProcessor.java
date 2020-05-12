package beandefinitionregistrypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义的 BeanDefinitionRegistryPostProcessor  是 BeanFactoryPostProcessor的子类，提供了一个扩展方法
 *
 * @author cy
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


	/**
	 * 扩展的方法：提供了一个注册器，可以动态的去注册bean
	 * @param registry the bean definition registry used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		for (int i = 0; i < 10; i++) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Person.class);
			builder.addPropertyValue("name", "cy_" + i);
			registry.registerBeanDefinition("person" + i, builder.getBeanDefinition());
		}
		System.out.println("动态注入bean完成");
	}

	/**
	 * 父类中的方法  #postProcessBeanFactory  可以修改、设置 bean的属性
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
