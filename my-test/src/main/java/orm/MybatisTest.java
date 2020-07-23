package orm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import orm.mapper.BlogMapper;
import orm.model.Blog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis 框架测试
 *
 * @author cy
 */
public class MybatisTest {

	public static void main(String[] args) throws IOException {
		//从 XML 中构建 SqlSessionFactory
		String resource = "mybatis_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Blog blog = blogMapper.selectBlog();
		System.out.println(blog);
	}

}
