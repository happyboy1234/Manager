package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-13:59
 */
public class StudentDaoTest extends BaseTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testtotalCount(){
        Integer integer = studentDao.totalCount("", 1, 1, "");
    }

    @Test
    public void testgetStudentList(){
        List<Student> list = studentDao.getStudentList("", 1, 1, "", 1, 1);
    }

    @Test
    public void testdeleteStudent(){
        int i = studentDao.deleteStudent(11);
    }

    @Test
    public void testaddStudent(){
        Student student = new Student();
        student.setS_studentid(11);
        student.setS_classid(141);
        student.setS_classname("s1mple");
        student.setS_age(21);
        student.setS_dormitoryid(105);
        int i = studentDao.addStudent(student);
        System.out.println(i);
    }

    @Test
    public void testupdateStudent(){
        Student student = new Student();
        student.setS_id(10086);
        student.setS_name("s1mple");
        int i = studentDao.updateStudent(student);
        System.out.println(i);
    }

    @Test
    public void testfindStudentById(){
        Student studentById = studentDao.findStudentById(1);
        System.out.println(studentById);
    }

    @Test
    public void testgetAll(){
        List<Student> all = studentDao.getAll();
        System.out.println(all);
    }
}

