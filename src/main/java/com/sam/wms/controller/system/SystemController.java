package com.sam.wms.controller.system;

import com.sam.wms.common.utils.BaseController;
import com.sam.wms.entity.SysGroup;
import com.sam.wms.mapper.SysGroupMapper;
import com.sam.wms.serivce.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SystemController extends BaseController{

    @Autowired
    SysGroupMapper sysGroupMapper;

    @Autowired
    SystemService systemService;

    @RequestMapping("/system/system")
    public String sytemList (HttpServletRequest request){
        List<SysGroup> grouplist = sysGroupMapper.findSysGroupList();
        request.setAttribute("sysGroupList",grouplist);
        return "system/system_system";
    }

}
