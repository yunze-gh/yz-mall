package com.yz.mall.web.aspect;

import com.yz.mall.web.annotation.RepeatSubmit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * 防重复提交AOP切面
 *
 * @author yunze
 * @date 2024/12/29 星期日 21:35
 */
@Aspect
@Component
public class RepeatSubmitAspect {

    private static Logger log = Logger.getLogger(RepeatSubmitAspect.class.getName());

    /**
     * 切入点为 {@link RepeatSubmit} 注解 <br/>
     * 所有添加了 {@link RepeatSubmit} 注解的方法，都会进入到当前AOP切面里
     */
    @Pointcut(value = "@annotation(repeatSubmit)")
    public void pointcutRepeatSubmit(RepeatSubmit repeatSubmit) {
    }


    @Around(value = "pointcutRepeatSubmit(repeatSubmit)", argNames = "joinPoint,repeatSubmit")
    public Object around(ProceedingJoinPoint joinPoint, RepeatSubmit repeatSubmit) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()).resolveReference(RequestAttributes.REFERENCE_REQUEST);

        assert request != null;
        String url = request.getRequestURI();
        String ipAddress = request.getRemoteAddr();
        log.warning("请求地址：" + ipAddress + "，请求接口" + url);
        if (url.contains("test")) {
            return "不允许重复提交，请稍后再试";
        }
        joinPoint.proceed();
        return joinPoint;
    }
}
