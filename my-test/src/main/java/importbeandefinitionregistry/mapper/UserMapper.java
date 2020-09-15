package importbeandefinitionregistry.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * 模拟mybatis接口
 *
 * @author cy
 */
public interface UserMapper {

	/**
	 * 查询user
	 */
	@Select("select * from user limit 1")
	String queryUser();

	/**
	 * 删除user
	 */
	@Select("delete from user where id = 1")
	void deleteUser();
}
