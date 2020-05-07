package beanfactorypostprocessor.config;

import beanfactorypostprocessor.model.BenzCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author cy
 */
@Configuration
@ComponentScan("beanfactorypostprocessor")
public class MyConfiguration {

	@Bean(initMethod = "initMethod")
	BenzCar benzCar(){
		BenzCar benzCar = new BenzCar();
		return benzCar;
	}


}
