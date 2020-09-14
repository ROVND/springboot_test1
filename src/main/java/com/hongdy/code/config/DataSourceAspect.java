package com.hongdy.code.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class DataSourceAspect {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.hongdy.code.controller.*.*(..))")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSourceHolder.setDataSource(DataSourceType.SLAVE.name());
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DataSourceHolder.clearDataSource();
        }
    }
}
