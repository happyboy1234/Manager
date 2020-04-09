package com.s1mple.dao;

import com.s1mple.entity.StudentClean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *学生卫生
 * @author s1mple
 * @create 2020/4/6-15:43
 */
public interface StudentCleanDao {

    /**
     * 获取总条数
     * @param s_studentid
     * @param s_name
     * @param s_dormitoryid
     * @return
     */
    public Integer totalCount(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name, @Param("s_dormitoryid") Integer s_dormitoryid);

    /**
     * 获取用户列表
     * @param s_studentid
     * @param s_name
     * @param s_dormitoryid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<StudentClean> getStudentCleanList(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     * 添加宿舍卫生信息
     * @param studentclean
     * @return
     */
    public int addStudentClean(StudentClean studentclean);

    /**
     * 删除宿舍卫生信息
     * @param g_id
     * @return
     */
    public int deleteStudentClean(Integer g_id);

    /**
     * 修改宿舍卫生信息
     * @param studentclean
     * @return
     */
    public int updateStudentClean(StudentClean studentclean);

    public StudentClean findStudentCleanById(Integer g_id);

    public List<StudentClean> getAll();
}
