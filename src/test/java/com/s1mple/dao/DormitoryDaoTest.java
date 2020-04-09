package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.Dormitory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-11:18
 */
public class DormitoryDaoTest extends BaseTest {

    @Autowired
    private DormitoryDao dormitoryDao;

    @Test
    public void testtotalCount(){
        Integer count = dormitoryDao.totalCount("杰", 601, "23号楼");
        System.out.println(count);
    }

    @Test
    public void testgetDormitoryList(){
        List<Dormitory> dormitoryList = dormitoryDao.getDormitoryList("", 11, "23", 1, 1);
        System.out.println(dormitoryList);
    }

    @Test
    public void testaddDormitory(){
        Dormitory dormitory = new Dormitory();
        dormitory.setA_name("八块钱我");
        dormitory.setS_dormitoryid(11);
        int i = dormitoryDao.addDormitory(dormitory);
        System.out.println(i);
    }

    @Test
    public void testdeleteDormitory(){
        int i = dormitoryDao.deleteDormitory(15);
        System.out.println(i);
    }

    @Test
    public void testupdateDormitory(){
        Dormitory dormitory = new Dormitory();
        dormitory.setA_name("哈哈");
        dormitory.setD_dormbuilding("");
        dormitory.setD_id(15);
        int i = dormitoryDao.updateDormitory(dormitory);
        System.out.println(i);
    }

    @Test
    public void testfindDormitoryById(){
        Dormitory dormitoryById = dormitoryDao.findDormitoryById(1);
        System.out.println(dormitoryById);
    }

    @Test
    public void testfindDormitoryStudent(){
        Dormitory dormitory = new Dormitory();
        dormitory.setA_name("周荀凯");
        List<Dormitory> dormitoryStudent = dormitoryDao.findDormitoryStudent(dormitory);
        System.out.println(dormitoryStudent);
    }

    @Test
    public void testgetAll(){
        List<Dormitory> all = dormitoryDao.getAll();
        System.out.println(all);
    }

}
