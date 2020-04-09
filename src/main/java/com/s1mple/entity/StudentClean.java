package com.s1mple.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 学生卫生
 * @author s1mple
 * @create 2020/4/5-16:57
 */
@Data
public class StudentClean {
    private Integer g_id;
    private Integer s_studentid;
    private String s_name;
    private Integer s_grade;
    private Integer s_classid;
    private Integer s_dormitoryid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;
}
