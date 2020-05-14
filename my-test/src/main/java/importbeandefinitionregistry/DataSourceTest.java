package importbeandefinitionregistry;

import importbeandefinitionregistry.config.MyConfiguration;
import importbeandefinitionregistry.mapper.CarMapper;
import importbeandefinitionregistry.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ImportBeanDefinitionRegistry模拟实现mybatis
 *
 * @author cy
 */
public class DataSourceTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		userMapper.queryUser();
		userMapper.deleteUser();

		System.out.println("------------------");

		CarMapper carMapper = (CarMapper) context.getBean("carMapper");
		carMapper.queryCar();
		carMapper.deleteCar();
	}

}
