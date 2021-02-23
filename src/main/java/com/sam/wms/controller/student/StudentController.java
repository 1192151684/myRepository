package com.sam.wms.controller.student;

import com.sam.wms.common.utils.BaseController;
import com.sam.wms.entity.Student;
import com.sam.wms.serivce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
    public class StudentController extends BaseController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student/student")
    public String product(HttpServletRequest request){
        List<Student > studentList = studentService.findStudentMapperList();
        request.setAttribute("studentList",studentList);
        return "student/student_student";
    }
}
