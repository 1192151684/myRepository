package com.sam.wms.controller.system;

import com.sam.wms.entity.SysGroup;
import com.sam.wms.mapper.SysGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SystemController {

    @Autowired
    SysGroupMapper sysGroupMapper;

    @RequestMapping("/system/system")
    public String sytemList (HttpServletRequest request){
      List<SysGroup> sysGroupList = sysGroupMapper.findSysGroupList();
        request.setAttribute("sysGroupList",sysGroupList);
        return "system/system_system";
    }
}
