package ioc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * order
 *
 * @author cy
 */
@Component("order")
public class OrderService {

	@Autowired
	UserService userService;

}
