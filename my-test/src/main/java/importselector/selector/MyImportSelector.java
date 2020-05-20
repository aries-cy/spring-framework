package importselector.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义的ImportSelector
 *
 * @author cy
 */
public class MyImportSelector implements ImportSelector {
	/**
	 * Spring在处理 @Import 的时候 会得到该方法返回的字符串，根据返回的字符串数组，new一个bd，并注册到容器中
	 * @param metadata 注解的数据
	 * @return 数组
	 */
	@Override
	public String[] selectImports(AnnotationMetadata metadata) {
		return new String[]{"importselector.model.Dog"};
	}
}
