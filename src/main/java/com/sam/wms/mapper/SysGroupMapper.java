package com.sam.wms.mapper;

import com.sam.wms.common.pageutils.Page;
import com.sam.wms.entity.SysGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface SysGroupMapper {

    List<SysGroup> findSysGroupList(Page page ,SysGroup sysGroup);
    List<SysGroup> findSysGroupList(Page page);

    List<SysGroup> findSysGroupList();
    int  findSysGroupCount();
}
