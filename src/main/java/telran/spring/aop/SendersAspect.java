package telran.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendersAspect {
static Logger LOG = LoggerFactory.getLogger("aop-telran");
@Around("execution(public * telran.spring.service..*(..))")
Object logger(ProceedingJoinPoint jp) throws Throwable {
	LOG.debug("class: {} method: {}",jp.getTarget().getClass().getSimpleName(),
			jp.getSignature().getName());
	return jp.proceed();
	
}
}
