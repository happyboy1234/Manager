package com.s1mple.service;

import com.s1mple.entity.PageInfo;
import com.s1mple.entity.Student;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:41
 */
public interface StudentService {
    /**
     *  分页查询
     * @param s_name
     * @param s_studentid
     * @param s_classid
     * @param s_classname
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid, Integer s_classid,
                                          String s_classname, Integer pageIndex, Integer pageSize);

    /**
     *  通过id删除学生信息
     * @param s_id
     * @return
     */
    public int deleteStudent(Integer s_id);

    /**
     *  添加学生信息
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
