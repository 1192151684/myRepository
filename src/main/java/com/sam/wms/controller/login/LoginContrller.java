package com.sam.wms.controller.login;

import com.sam.wms.common.utils.BaseController;
import com.sam.wms.common.enums.ResultType;
import com.sam.wms.entity.SysUser;
import com.sam.wms.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginContrller extends BaseController {

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
        //todo

        return "login/login";
    }

    @ResponseBody
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(HttpServletRequest request) {
        String account = request.getParameter("account");
        String passWord = request.getParameter("passWord");
       /* if(account.isEmpty() || passWord.isEmpty()){
            return resultMassageTojson(ResultType.OPERATION_FAIL.getCode(),"请输入密码",null);
        }
        try {
            SysUser sysUser = userService.checkUserSignature(account, passWord);
            return resultMassageTojson(ResultType.SUCCESS.getCode(),null,sysUser);
        }catch (RuntimeException e){
            return resultMassageTojson(ResultType.SYSTEM_ERR.getCode(),e.getMessage(),null);

        }*/
        SysUser sysUser = new SysUser();
        sysUser.setId(0);
        sysUser.setName("admin");
        sysUser.setPassword("123");
        sysUser.setAccount("sfsdf");
        sysUser.setAdmin(true);
        return resultMassageTojson(ResultType.SUCCESS.getCode(), null, sysUser);
    }

    /**
     * 加载组织结构
     *
     * @param
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        String userIdReq = request.getParameter("userId");
        System.out.print(userIdReq);
        Integer userId = null;
        try {
            //1、身份识别
            userId = Integer.parseInt(userIdReq);
            SysUser sysUser = userService.findAcountInfo(userId);
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


