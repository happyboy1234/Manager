package com.s1mple.service;

import com.s1mple.BaseTest;
import com.s1mple.entity.Class;
import com.s1mple.entity.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-15:57
 */
public class ClassServiceTest extends BaseTest {

    @Autowired
    private ClassService classService;

    @Test
    public void testgetAll(){
        List<Class> all = classService.getAll();
        System.out.println(all);
    }

    @Test
    public void testdeleteClass(){
        int i = classService.deleteClass(12);
        System.out.println(i);
    }

    @Test
    public void testaddClass(){
        Class aClass = new Class();
        aClass.setC_classid(120);
        aClass.setC_classname("哲学");
        int i = classService.addClass(aClass);
        System.out.println(i);
    }

    @Test
    public void testfindClassById(){
        Class classById = classService.findClassById(12);
        System.out.println(classById);
    }

    @Test
    public void testupdateClass(){
        Class aClass = new Class();
        aClass.setC_id(11);
        aClass.setC_classid(111);
        aClass.setC_classname("心理学");
        int i = classService.updateClass(aClass);
        System.out.println(i);
    }

    @Test
    public void testfindClassStudent(){
        Class aClass = new Class();
        aClass.setC_id(11);
        aClass.setC_classname("心理学");
        List<Class> classStudent = classService.findClassStudent(aClass);
        System.out.println(classStudent);
    }
    

    @Test
    public void testfindPageInfo(){
        PageInfo<Class> pageInfo = classService.findPageInfo("JAVA", "AVA", 1, 1, 1);
        System.out.println(pageInfo);
    }
}
