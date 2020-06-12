package ioc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * user
 *
 * @author cy
 */
@Component("user")
public class UserService {
	@Autowired
	OrderService orderService;
}
