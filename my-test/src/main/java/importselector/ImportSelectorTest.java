package importselector;

import importselector.config.ImportSelectorConfiguration;
import importselector.model.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 *
 * @author cy
 */
public class ImportSelectorTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportSelectorConfiguration.class);
		Dog dog = context.getBean(Dog.class);
		dog.test();
		System.out.println(dog);
	}

}
