package importbeandefinitionregistry.config;

import importbeandefinitionregistry.myannotation.MyMapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO 描述
 *
 * @author cy
 */
@Configuration
@MyMapperScan("importbeandefinitionregistry.mapper")
public class MyConfiguration {
}
