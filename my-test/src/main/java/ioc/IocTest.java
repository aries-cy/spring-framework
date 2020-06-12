package ioc;

import ioc.config.IocConfiguration;
import ioc.model.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring bean 的装配测试
 *
 * @author cy
 */
public class IocTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfiguration.class);
		OrderService order = (OrderService) context.getBean("order");
		System.out.println("...");
	}
}
