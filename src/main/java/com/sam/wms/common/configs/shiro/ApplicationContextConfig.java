package com.sam.wms.common.configs.shiro;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author sam
 * date:2021.04.2021/4/8
 * time:0:42
 */
@Component
public class ApplicationContextConfig implements ApplicationContextAware {

    private static ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static Object getBean(String beamName){
        return context.getBean(beamName);
    }
}
