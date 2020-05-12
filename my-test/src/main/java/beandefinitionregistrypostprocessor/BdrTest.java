package beandefinitionregistrypostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 测试类
 *
 * @author cy
 */
public class BdrTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BdrConfig.class);
		Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
		beansOfType.forEach((k,v)->{
			System.out.println(k+">>>"+v.toString());
		});
		System.out.println(beansOfType.size());
	}
}
