package com.s1mple.dao;

import com.s1mple.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 * @author s1mple
 * @create 2020/4/5-22:44
 */
public interface StudentDao {

    /**
     * 获取总条数
     * @param s_name
     * @param s_studentid
     * @param s_classid
     * @param s_classname
     * @return
     */
    public Integer totalCount(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid,
                              @Param("s_classid")Integer s_classid, @Param("s_classname")String s_classname);

    /**
     * 获取用户列表
     * @param s_name
     * @param s_studentid
     * @param s_classid
     * @param s_classname
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Student> getStudentList(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid, @Param("s_classid")Integer s_classid,
                                        @Param("s_classname")String s_classname, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    /**
     * 删除学生信息
     * @param s_id
     * @return
     */
    public int deleteStudent(Integer s_id);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    public int addStudent(Student student);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    public Student findStudentById(Integer s_id);

    public List<Student> getAll();

}
