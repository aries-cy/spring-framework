package importbeandefinitionregistry.myannotation;

import importbeandefinitionregistry.registrar.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 扫描注解
 *
 * @author cy
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {
	String[] value() default {};
}
