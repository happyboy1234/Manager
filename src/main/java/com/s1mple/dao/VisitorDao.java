package com.s1mple.dao;

import com.s1mple.entity.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**访客
 * @author s1mple
 * @create 2020/4/6-15:45
 */
public interface VisitorDao {

    /**
     * 获取总条数
     * @param v_name
     * @param v_phone
     * @return
     */
    public Integer totalCount(@Param("v_name") String v_name, @Param("v_phone")Integer v_phone);

    /**
     * 获取用户列表
     * @param v_name
     * @param v_phone
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Visitor> getVisitorList(@Param("v_name") String v_name, @Param("v_phone")Integer v_phone, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    /**
     * 添加学生信息
     * @param visitor
     * @return
     */
    public int addVisitor(Visitor visitor);

    public List<Visitor> getAll();

}
