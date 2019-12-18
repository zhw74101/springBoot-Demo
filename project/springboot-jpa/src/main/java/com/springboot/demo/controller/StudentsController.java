package com.springboot.demo.controller;

import com.springboot.demo.dao.StudentRepository;
import com.springboot.demo.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhanghongwei on 2019/12/18.
 */
@RestController
@RequestMapping("jpa")
public class StudentsController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "bystuname/{stuName}",produces="application/json;charset=UTF-8")
    public Students getOneByStuName(@PathVariable("stuName") String stuName){
        Students students = studentRepository.findByStuName(stuName);
        return students;
    }

    @RequestMapping("bystuage/{stuAge}")
    public Students getOneByStuAge(@PathVariable("stuAge") int stuAge){
        return studentRepository.findByStuAge(stuAge);
    }

    @RequestMapping("bystuname/{stuName}/{stuSex}")
    public Students getOne(@PathVariable("stuName") String stuName,@PathVariable("stuSex") String stuSex){
        return studentRepository.findByStuNameAndStuSex(stuName,stuSex);
    }


}
