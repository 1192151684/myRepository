package com.sam.wms.mapper;

import com.sam.wms.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface StudentMapper{
        List <Student> findStudentMapperList();

}

