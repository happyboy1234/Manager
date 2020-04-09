package com.s1mple.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 宿舍卫生
 * @author s1mple
 * @create 2020/4/5-16:53
 */
@Data
public class DormClean {

    private Integer g_id;
    private Integer d_id;
    private String  d_dormbuilding;
    private Integer d_grade;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;
}
