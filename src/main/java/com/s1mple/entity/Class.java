package com.s1mple.entity;

import lombok.Data;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/5-16:51
 */
@Data
public class Class {

    private  Integer c_id;
    private  Integer c_classid;
    private  String  c_classname;
    private  String  c_counsellor;
    //班级与学生为一对多关系，使用链表
    private List<Student>  students;

}
