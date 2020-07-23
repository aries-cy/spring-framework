package orm;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import orm.mapper.BlogMapper;
import orm.model.Blog;

/**
 * Mybatis-Spring
 *
 * @author cy
 */
public class MybatisSpringTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:mybatis-spring.xml");

		SqlSessionFactoryBean sqlSessionFactoryBean = context.getBean(SqlSessionFactoryBean.class);
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean.getObject());

		BlogMapper mapper = sqlSessionTemplate.getMapper(BlogMapper.class);
		Blog blog = mapper.selectBlog();
		System.out.println(blog);
	}

}
