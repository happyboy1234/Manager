package com.s1mple.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 维修登记
 * @author s1mple
 * @create 2020/4/5-16:55
 */
@Data
public class DormRepair {
    private int r_id;
    private int d_id;
    private int d_dormbuilding;
    private String r_name;
    private String reason;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;
}
