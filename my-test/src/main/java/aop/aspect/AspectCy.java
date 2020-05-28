package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面
 *
 * @author cy
 */

@Component
@Aspect
public class AspectCy {

	@Pointcut("execution(* aop.dao..*.*(..))")
	public void pintCut(){

	}

	@Before("pintCut()")
	public void before(){
		System.out.println("proxy before...");
	}
}
