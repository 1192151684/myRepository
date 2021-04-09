package com.sam.wms.common.configs.realms;

import com.sam.wms.common.configs.shiro.ApplicationContextConfig;
import com.sam.wms.entity.SysUser;
import com.sam.wms.serivce.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * @author sam
 * date:2021.04.2021/4/7
 * time:21:45
 * @desc：授权
 */
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        UserService userService = (UserService) ApplicationContextConfig.getBean("userService");

        try {
            SysUser sysUser = userService.checkUserSignatureByAccount(principal);
            if(sysUser.getAccount().equals(principal)){
                return new SimpleAuthenticationInfo(principal,sysUser.getPassword(),this.getName());
            }else {
                return  null;
            }
        }catch (Exception e){
            return  null;
        }
    }
}
