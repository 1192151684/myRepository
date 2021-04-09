package com.sam.wms.controller.login;

import com.sam.wms.common.enums.LoginType;
import com.sam.wms.common.utils.BaseController;
import com.sam.wms.common.enums.ResultType;
import com.sam.wms.entity.SysUser;
import com.sam.wms.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * ajax 请求校验用户
     *
     * @param
     * @return
     */
    @RequestMapping("/")
    public String userLogin() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(String account, String passWord) {
        SysUser sysUser = null;
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken(account,passWord));
            sysUser = userService.checkUserSignature(account,passWord);
            return toJson(resultMassage(ResultType.SUCCESS.getCode(),ResultType.SUCCESS.getDesc(), sysUser));
        }catch (UnknownAccountException e){
            return toJson(resultMassage(LoginType.ACCOUNT_REE.getCode(),LoginType.ACCOUNT_REE.getDesc(), null));
        }catch (IncorrectCredentialsException e){
            return toJson(resultMassage(LoginType.PASS_WORD.getCode(),LoginType.PASS_WORD.getDesc(), null));
        }
    }

    @GetMapping("/user")
    public String userInfo(HttpServletRequest request , String userId){
        try {
           Integer userIdInt = Integer.parseInt(userId);
            SysUser sysUser = userService.findAcountInfo(userIdInt);
            request.setAttribute("sysUser", sysUser);
        }catch (Exception e){

        }
        return "common/user_info";
    }

    /**
     * 加载组织结构
     *
     * @param
     * @return
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        String userIdReq = request.getParameter("userId");
        if(userIdReq == null || userIdReq =="" || userIdReq.equals("")){
            return "redirect:/login";
        }


        Integer userId = 0;
        try {
            //1、身份识别
            userId = Integer.parseInt(userIdReq);
            SysUser sysUser = userService.findAcountInfo(userId);
            if(sysUser == null){
                return "redirect:/login";
            }
            //2、身份对应的资源组织
            Map<String, Object> groupMap = userService.selectGroupList();
            request.setAttribute("sysUser", sysUser);
            request.setAttribute("groupMap", groupMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "common/index";
    }

}


