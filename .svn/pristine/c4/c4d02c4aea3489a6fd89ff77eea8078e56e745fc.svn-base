package net.sjmworld.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {

	@Before("execution(* net.sjmworld.service.SampleService*.*(..))")
	public void logAdvice() {
		log.info("================================================");
	}
	
	@Around("execution(* net.sjmworld.service.*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object obj;
		obj =pjp.proceed();
		
		long end = System.currentTimeMillis();
		Object[] args = pjp.getArgs();
		String[] strs = new String[args.length];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = args[i].toString();
		}
		String str =String.join(",", strs);
		log.info(String.format("%s.%s(%s) %d ms",
				pjp.getTarget().getClass().getSimpleName(),
				pjp.getSignature().getName(),
				str,
				end - start ));
		return obj;
	}
}
