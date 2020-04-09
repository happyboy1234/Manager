package com.s1mple.service;

import com.s1mple.entity.PageInfo;
import com.s1mple.entity.StudentClean;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:40
 */
public interface StudentCleanService {
    /**
     * 分页查询
     * @param s_studentid
     * @param s_name
     * @param s_dormitoryid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<StudentClean> findPageInfo(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize);

    /**
     *  添加宿舍信息
     * @param studentclean
     * @return
     */
    public int addStudentClean(StudentClean studentclean);

    /**
     *  删除宿舍信息
     * @param g_id
     * @return
     */
    public int deleteStudentClean(Integer g_id);

    /**
     *  修改宿舍信息
     * @param studentclean
     * @return
     */
    public int updateStudentClean(StudentClean studentclean);

    public StudentClean findStudentCleanById(Integer g_id);

    public List<StudentClean> getAll();
}
