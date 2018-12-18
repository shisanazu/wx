package com.test.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class BeanUtil implements ApplicationContextAware{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public <T> Map<String, T> getBean(Class<T> var1) {
        Map<String, T> var2 = applicationContext.getBeansOfType(var1);
        return var2;
    }
}
