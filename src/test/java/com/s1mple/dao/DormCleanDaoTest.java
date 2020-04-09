package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.DormClean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-11:04
 */
public class DormCleanDaoTest extends BaseTest {

    @Autowired
    private DormCleanDao dormCleanDao;

    @Test
    public void testtotalCount(){
        Integer count = dormCleanDao.totalCount(321, "21号");
        System.out.println(count);
    }

    @Test
    public void testgetDormCleanList(){
        List<DormClean> dormCleanList = dormCleanDao.getDormCleanList(31, "", 11, 1);
        System.out.println(dormCleanList);
    }

    @Test
    public void testaddDormClean(){
        DormClean clean = new DormClean();
        clean.setD_id(12);
        clean.setD_dormbuilding("28号楼");
        clean.setD_grade(10);
        int i = dormCleanDao.addDormClean(clean);
        System.out.println(i);
    }

    @Test
    public void testdeleteDormClean(){
        int i = dormCleanDao.deleteDormClean(8);
        System.out.println(i);
    }

    @Test
    public void testupdateDormClean(){
        DormClean dormClean = new DormClean();
        dormClean.setG_id(7);
        dormClean.setD_grade(11);
        int i = dormCleanDao.updateDormClean(dormClean);
        System.out.println(i);
    }

    @Test
    public void testfindDormCleanById(){
        DormClean dormCleanById = dormCleanDao.findDormCleanById(11);
        System.out.println(dormCleanById);
    }

    @Test
    public void testgetAll(){
        List<DormClean> all = dormCleanDao.getAll();
        System.out.println(all);
    }
}
