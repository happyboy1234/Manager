package com.s1mple.entity;

import lombok.Data;

/**
 * @author s1mple
 * @create 2020/4/5-16:52
 */
@Data
public class Student {

    private static final long serialVersionUID = 1L;
    private  Integer s_id;
    private  Integer s_studentid;
    private  String  s_name;
    private  String  s_sex;
    private  Integer  s_age;
    private  Integer  s_phone;
    private  Integer  s_classid;
    private  String s_classname;
    private  Integer  s_dormitoryid;

}
