package com.sam.wms.serivce;

import com.sam.wms.entity.Product;
import com.sam.wms.entity.Student;
import com.sam.wms.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<Student> findStudentMapperList(){
        List<Student>  findStudentMapperList = studentMapper.findStudentMapperList();
        return findStudentMapperList;
    }

}
