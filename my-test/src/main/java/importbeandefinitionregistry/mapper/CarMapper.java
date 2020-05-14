package importbeandefinitionregistry.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * 模拟mybatis接口
 *
 * @author cy
 */
public interface CarMapper {

	/**
	 * 查询car
	 */
	@Select("select * from car limit 1")
	void queryCar();

	/**
	 * 删除car
	 */
	@Select("delete from car where id = 1")
	void deleteCar();
}
