package importselector;

import importselector.selector.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 *
 * @author cy
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
public @interface MyScan {

	String[] value();
}
