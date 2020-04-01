import bean.User;
import config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO 描述
 *
 * @author cy
 */
public class MyTestApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		User user = (User) context.getBean("user");
		System.out.println(user);
	}
}
