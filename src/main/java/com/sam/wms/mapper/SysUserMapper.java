package com.sam.wms.mapper;

import com.sam.wms.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SysUserMapper {

   SysUser findUserBySignature(SysUser sysUserParam);

   SysUser findUserBySignatureByAccount(String account);

   SysUser findUserByPrimary(Integer userId);
}
