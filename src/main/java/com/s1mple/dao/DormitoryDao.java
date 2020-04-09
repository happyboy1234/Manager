package com.s1mple.dao;

import com.s1mple.entity.Dormitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-15:40
 */
public interface DormitoryDao {
    /**
     *  获取总条数
     * @param a_name
     * @param s_dormitoryid
     * @param d_dormbuilding
     * @return
     */
    public Integer totalCount(@Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("d_dormbuilding") String d_dormbuilding);

    /**
     * 获取用户列表
     * @param a_name
     * @param s_dormitoryid
     * @param d_dormbuilding
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Dormitory> getDormitoryList(@Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     * 添加宿舍信息
     * @param dormitory
     * @return
     */
    public int addDormitory(Dormitory dormitory);

    /**
     * 删除宿舍信息
     * @param d_id
     * @return
     */
    public int deleteDormitory(Integer d_id);

    /**
     * 修改宿舍信息
     * @param dormitory
     * @return
     */
    public int updateDormitory(Dormitory dormitory);

    public Dormitory findDormitoryById(Integer d_id);

    /**
     *  查询宿舍人员信息
     * @param dormitory
     * @return
     */
    public List<Dormitory> findDormitoryStudent(Dormitory dormitory);

    public List<Dormitory> getAll();
}
