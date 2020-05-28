package aop;

import aop.config.AopConfiguration;
import aop.dao.OrderDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AopTest
 *
 * @author cy
 */
public class AopTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
		OrderDao orderDao = context.getBean(OrderDao.class);
		orderDao.test();
	}
}
