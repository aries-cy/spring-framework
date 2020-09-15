package orm.mapper;

import org.apache.ibatis.annotations.Mapper;
import orm.model.Blog;

/**
 * userMapper
 *
 * @author cy
 */
public interface BlogMapper {

	/**
	 * select
	 * @return Blog
	 */
	Blog selectBlog();

	/**
	 * 更新
	 * @param title title
	 */
	void updateBlog(String title);

}
