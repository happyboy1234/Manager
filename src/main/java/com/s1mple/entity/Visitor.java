package com.s1mple.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 访客
 * @author s1mple
 * @create 2020/4/5-16:57
 */
public class Visitor {
    private Integer v_id;
    private String v_name;
    private Integer v_phone;
    private Integer v_dormitoryid;
    private String v_dormbuilding;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
}
