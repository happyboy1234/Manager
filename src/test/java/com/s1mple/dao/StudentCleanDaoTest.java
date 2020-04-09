package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.StudentClean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-11:52
 */
public class StudentCleanDaoTest extends BaseTest {

    @Autowired
    private StudentCleanDao studentCleanDao;

    @Test
    public void testtotalCount(){
        Integer count = studentCleanDao.totalCount(1, "张杰", 123456);
        System.out.println(count);
    }

    @Test
    public void testgetStudentCleanList(){
        List<StudentClean> studentCleanList = studentCleanDao.getStudentCleanList(1, "", 1, 1, 1);
        System.out.println(studentCleanList);
    }

    @Test
    public void testaddStudentClean(){
        StudentClean studentClean = new StudentClean();
        studentClean.setS_name("理想");
        studentClean.setS_grade(9);
        studentClean.setS_studentid(1515345341);
        int i = studentCleanDao.addStudentClean(studentClean);
        System.out.println(i);
    }

    @Test
    public void testdeleteStudentClean(){
        int i = studentCleanDao.deleteStudentClean(11);
        System.out.println(i);
    }

    @Test
    public void testupdateStudentClean(){
        StudentClean studentClean = new StudentClean();
        studentClean.setS_studentid(11);
        studentClean.setS_name("s1mple");
        studentClean.setS_grade(4);
        int i = studentCleanDao.updateStudentClean(studentClean);
        System.out.println(i);
    }

    @Test
    public void testfindStudentCleanById(){
        StudentClean studentCleanById = studentCleanDao.findStudentCleanById(5);
        System.out.println(studentCleanById);
    }

    @Test
    public void testgetAll(){
        List<StudentClean> all = studentCleanDao.getAll();
        System.out.println(all.toString());
    }
}

