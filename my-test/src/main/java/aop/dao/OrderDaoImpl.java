package aop.dao;

import org.springframework.stereotype.Component;

/**
 * TestServiceImpl
 *
 * @author cy
 */
@Component
public class OrderDaoImpl implements OrderDao {
	@Override
	public void test() {
		System.out.println("OrderDaoImpl... ");
	}
}
