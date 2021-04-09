package com.sam.wms.common.configs.shiro;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.sam.wms.common.configs.realms.UserRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sam
 * date:2021.04.2021/4/7
 * time:21:13ShiroConfig
 */
@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String ,String> param = new HashMap<>();


        //配置不要授权的资源

        param.put("/login","anon");
        param.put("/logout","anon");
        param.put("/","anon");
        param.put("/common/common_js.html","anon");
        param.put("/checkUser","anon");

        param.put("/css/**","anon");
        param.put("/fonts/**","anon");
        param.put("/font/**","anon");
        param.put("/images/**","anon");
        param.put("/js/**","anon");
        param.put("/lib/**","anon");

        //配送授权的资源
        param.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(param);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

   @Bean(name = "realm")
    public Realm getRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect getshiroDialect(){
        return new ShiroDialect();
    }


}
