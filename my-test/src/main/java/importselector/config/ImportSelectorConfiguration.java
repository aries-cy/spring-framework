package importselector.config;

import importselector.MyScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author cy
 */
@Configuration
@MyScan("importselector.model")
public class ImportSelectorConfiguration {
}
