package beanpostproceessor.service.impl;

import beanpostproceessor.service.HelloService;
import beanpostproceessor.service.NameInit;
import org.springframework.stereotype.Service;

/**
 * 具体的业务逻辑
 *
 * @author cy
 */
@Service
public class HelloServiceImpl implements HelloService, NameInit {

	private String name;

	@Override
	public void sayHello() {
		System.out.println("hello "+ name);
	}

	@Override
	public void setName(String name) {
		this.name =  name;
	}
}
