package importbeandefinitionregistry.factorybean;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自定义的 FactoryBean
 *
 * @author cy
 */
public class MyMapperFactoryBean  implements FactoryBean ,InvocationHandler{

	private Class interfaceClass;

	public MyMapperFactoryBean(Class interfaceClass){
		this.interfaceClass = interfaceClass;
	}

	/**
	 *
	 * @return 返回代理对象
	 * @throws Exception 异常
	 */
	@Override
	public Object getObject() throws Exception {
		return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{interfaceClass},this);
	}

	/**
	 *
	 * @return 返回class
	 */
	@Override
	public Class<?> getObjectType() {
		return interfaceClass;
	}

	/**
	 * 打印出注解中的sql
	 * @param proxy 代理
	 * @param method 方法
	 * @param args 参数
	 * @return object
	 * @throws Throwable 异常
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String sql = method.getDeclaredAnnotation(Select.class).value()[0];
		//打印sql
		System.out.println(sql);
		return null;
	}
}
