package com.sam.wms.mapper;

import com.sam.wms.entity.SysGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface SysGroupMapper {

    List<SysGroup> findSysGroupList();
    int  findSysGroupCount();
}
