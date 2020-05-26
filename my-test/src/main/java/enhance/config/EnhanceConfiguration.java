package enhance.config;

import enhance.model.IndexDao1;
import enhance.model.IndexDao2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author cy
 */
@ComponentScan("enhance.model")
@Configuration
public class EnhanceConfiguration {

	@Bean
	public IndexDao1 indexDao1(){
		return new IndexDao1();
	}

	@Bean
	public IndexDao2 indexDao2(){
		/**
		 * 当当前配置类没有加 @Configuration	注解时，会调用2次 indexDao1 的构造方法
		 * 加了 @Configuration 注解时，只会调用1次 indexDao1 的构造方法
		 *
		 * 因为Spring为 @Configuration 产生了 cglib 代理
		 * 增强了接口 ：BeanFactoryAware ，调用 BeanFactoryAware 中的 setBeanFactory为其添加了成员变量 $$beanFactory
		 * 就可以通过 beanFactory 去 getBean
		 */
		indexDao1();
		return new IndexDao2();
	}
}
