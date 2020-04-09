package com.s1mple.service;

import com.s1mple.entity.PageInfo;
import com.s1mple.entity.Visitor;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:42
 */
public interface VisitorService {


    /**
     *  分页查询
     * @param v_name
     * @param v_phone
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Visitor> findPageInfo(String v_name, Integer v_phone , Integer pageIndex, Integer pageSize);

    /**
     *  添加访客信息
     * @param visitor
     * @return
     */
    public int addVisitor(Visitor visitor);

    public List<Visitor> getAll();
}
