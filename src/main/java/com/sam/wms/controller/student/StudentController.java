package com.sam.wms.controller.student;

import com.google.gson.Gson;
import com.sam.wms.common.enums.LayuiCodeUtils.LayuiCode;
import com.sam.wms.common.utils.BaseController;
import com.sam.wms.entity.Student;
import com.sam.wms.serivce.StudentService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
    public class StudentController extends BaseController {


    @Autowired
    StudentService studentService;

    @RequestMapping("/student/student")
    public String selectStu(HttpServletRequest request){
        List<Student> sysGroupList =  studentService.findStudentMapperList();
        request.setAttribute("studentList",sysGroupList);
        return "student/student_student";
    }


    @PostMapping(value = "/getList")
    public Object  exportData(HttpServletRequest request) {
        List<Student> list =  studentService.findStudentMapperList();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data",list);
            map.put("code","0");
            map.put("msg","成功");
            map.put("msg","count");
            Gson gson  = new Gson();
            return gson.toJson(map);
    }

}
