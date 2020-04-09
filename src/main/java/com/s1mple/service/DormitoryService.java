package com.s1mple.service;

import com.s1mple.entity.Dormitory;
import com.s1mple.entity.PageInfo;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:38
 */
public interface DormitoryService {

    /**
     * 分页查询
     * @param a_name
     * @param s_dormitoryid
     * @param d_dormbuilding
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid, String d_dormbuilding, Integer pageIndex, Integer pageSize);

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
     * 查询宿舍人员信息
     * @param dormitory
     * @return
     */
    public List<Dormitory> findDormitoryStudent(Dormitory dormitory);

    public List<Dormitory> getAll();

}
