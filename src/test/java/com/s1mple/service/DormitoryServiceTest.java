package com.s1mple.service;

import com.s1mple.BaseTest;
import com.s1mple.entity.Dormitory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author s1mple
 * @create 2020/4/8-11:15
 */
public class DormitoryServiceTest extends BaseTest {

    @Autowired
    private DormitoryService dormitoryService;

    @Test
    public void findPageInfo() {
    }

    @Test
    public void addDormitory() {
    }

    @Test
    public void deleteDormitory() {
        int i = dormitoryService.deleteDormitory(111);
        System.out.println(i);
    }

    @Test
    public void updateDormitory() {
        Dormitory dormitory = new Dormitory();
        dormitory.setD_id(111);
        dormitory.setA_name("不知道");
        dormitory.setD_dormbuilding("不知道");
        int i = dormitoryService.updateDormitory(dormitory);
        System.out.println(i);
    }

    @Test
    public void findDormitoryById() {
        Dormitory dormitoryById = dormitoryService.findDormitoryById(11);
        System.out.println(dormitoryById);
    }

    @Test
    public void findDormitoryStudent() {
        Dormitory dormitory = new Dormitory();
        List<Dormitory> dormitoryStudent = dormitoryService.findDormitoryStudent(dormitory);
        System.out.println(dormitoryStudent);
    }

    @Test
    public void getAll() {
        List<Dormitory> all = dormitoryService.getAll();
        System.out.println(all);
    }
}