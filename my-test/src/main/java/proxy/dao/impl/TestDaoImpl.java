package proxy.dao.impl;

import proxy.dao.TestDao;

/**
 * mapper接口
 *
 * @author cy
 */
public class TestDaoImpl implements TestDao {
	@Override
	public void test() {
		System.out.println("test dao impl");
	}
}
