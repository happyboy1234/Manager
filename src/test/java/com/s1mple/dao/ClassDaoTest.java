package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.Class;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-10:23
 */
public class ClassDaoTest extends BaseTest {

    @Autowired
    private ClassDao classDao;

    @Test
    public void testtotalCount(){
        Integer count = classDao.totalCount("生物", 141, "徐超");
        System.out.println(count);
    }

    @Test
    public void testgetClassList(){
        List<Class> classList = classDao.getClassList("生物", 141, "刘超", 1, 1);
        System.out.println(classList);
    }

    @Test
    public void testdeleteClass(){
        int i = classDao.deleteClass(11);
        System.out.println(i);
    }

    @Test
    public void testaddClass(){
        Class aClass = new Class();
        aClass.setC_classname("计算机");
        aClass.setC_counsellor("s1mple");
        aClass.setC_classid(110);
        int i = classDao.addClass(aClass);
        System.out.println(i);
    }

    @Test
    public void testupdateClass(){
        Class aClass = new Class();
        aClass.setC_id(11);
        aClass.setC_classname("JAVA");
        int i = classDao.updateClass(aClass);
        System.out.println(i);
    }

    @Test
    public void testfindClassById(){
        Class aClass = classDao.findClassById(11);
        System.out.println(aClass);
    }

    @Test
    public void testfindClassStudent(){
        Class aClass = new Class();
        aClass.setC_classname("JAVA");
        aClass.setC_id(11);
        List<Class> student = classDao.findClassStudent(aClass);
        System.out.println(student);
    }
}
