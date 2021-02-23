package com.sam.wms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface RoleMapper {

    List<String > roleMapperList (String roleList);

}
