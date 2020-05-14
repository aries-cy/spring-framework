package importbeandefinitionregistry.registrar;

import importbeandefinitionregistry.factorybean.MyMapperFactoryBean;
import importbeandefinitionregistry.myannotation.MyMapperScan;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的ImportBeanDefinitionRegistrar
 *
 * @author cy
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar , ResourceLoaderAware {
	private static final String VALUE = "value";
	private ResourceLoader resourceLoader;

	/**
	 * 提供了注解信息（importingClassMetadata）和一个注册器（registry）
	 * @param importingClassMetadata annotation metadata of the importing class
	 * @param registry current bean definition registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//取到相关的注解信息（包名），并进行扫描，通过代理构造对象，注册到bean容器中
		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
				importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
		if(null!=annotationAttributes){
			for(String path : getScanPath(annotationAttributes)){
				//通过FactoryBean去动态生成接口的代理对象
				BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyMapperFactoryBean.class);
				AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
				//将接口的全路径 作为参数 传给FactoryBean 生成代理对象
				beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(path);
				//将beanDefinition注册到容器中
				registry.registerBeanDefinition(lowerFirst(path.substring(path.lastIndexOf(".")+1)),beanDefinition);
			}
		}
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	/**
	 * 得到注解中包下的接口全路径
	 * @param annotationAttributes 注解
	 * @return 注解中包下的接口全路径
	 */
	private List<String> getScanPath(AnnotationAttributes annotationAttributes){
		List<String> scanPath = new ArrayList<>();
		for(String basePackage:annotationAttributes.getStringArray(VALUE)){
			ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
			MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resolver);
			try {
				Resource[] resources = resolver.getResources("classpath*:" + basePackage.replace('.', '/') + "/**/*.class");
				for(Resource resource:resources){
					MetadataReader metadataReader = readerFactory.getMetadataReader(resource);
					scanPath.add(metadataReader.getClassMetadata().getClassName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return scanPath;
	}

	/**
	 * 首字母变小写
	 * @param oldStr 需要转换的string
	 * @return 转换后的string
	 */
	private String lowerFirst(String oldStr){
		char[] charArray = oldStr.toCharArray();
		charArray[0] += 32;
		return String.valueOf(charArray);
	}
}
