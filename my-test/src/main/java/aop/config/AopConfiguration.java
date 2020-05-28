package aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AopConfiguration
 *
 * @author cy
 */
@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy
public class AopConfiguration {
}
