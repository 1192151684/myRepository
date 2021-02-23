package com.sam.wms.serivce;

import com.sam.wms.entity.SysGroup;
import com.sam.wms.entity.SysUser;
import com.sam.wms.mapper.SysGroupMapper;
import com.sam.wms.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysGroupMapper sysGroupMapper;

    public SysUser checkUserSignature(String account, String passWord) throws RuntimeException {
        SysUser sysUserParam = new SysUser();
        sysUserParam.setAccount(account);
        sysUserParam.setPassword(passWord);
        SysUser sysUser = sysUserMapper.findUserBySignature(sysUserParam);
        if (sysUser == null) {
            throw new RuntimeException("用户名不存在，或者密码输入错误");
        }
        if (!sysUser.getName().isEmpty()) {
            return sysUser;
        }
        return null;
    }

    public SysUser findAcountInfo(Integer userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(0);
        return sysUser;
    }

    public Map<String,Object> selectGroupList() {
        List<SysGroup> sysGroupList = sysGroupMapper.findSysGroupList(); //查询分组信息
        Map<String,Object>  sysGroupRsqMap = new HashMap<String,Object>();
        List<SysGroup> parentSysGroupList = new ArrayList<SysGroup>();
        if(sysGroupList.size() != 0){
           sysGroupList.forEach(item ->{
              if(item.getParentId() == 0){
                  parentSysGroupList.add(item); //添加1级菜单
              }
           });
        }
        sysGroupRsqMap.put("parentSysGroupList", parentSysGroupList);
        sysGroupRsqMap.put("subSysGroupList", sysGroupList);
        return sysGroupRsqMap;
    }

    public List<SysUser> findUserList() {

        return  sysUserMapper.findUserAll();
    }
}