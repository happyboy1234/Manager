package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.DormRepair;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-11:37
 */
public class DormRepairDaoTest extends BaseTest {

    @Autowired
    private DormRepairDao dormRepairDao;

    @Test
    public void testtotalCount(){
        Integer count = dormRepairDao.totalCount(301, "24号楼");
        System.out.println(count);
    }

    @Test
    public void testgetDormRepairList(){
        List<DormRepair> dormRepairList = dormRepairDao.getDormRepairList(301, "", 1, 1);
        System.out.println(dormRepairList);
    }

    @Test
    public void testaddDormRepair(){
        DormRepair dormRepair = new DormRepair();
        dormRepair.setD_id(506);
        dormRepair.setD_dormbuilding(12);
        dormRepair.setR_name("s1mple");
        dormRepair.setReason("123456");
        int i = dormRepairDao.addDormRepair(dormRepair);
        System.out.println(i);
    }

    @Test
    public void testdeleteDormRepair(){
        int i = dormRepairDao.deleteDormRepair(7);
        System.out.println(i);
    }

    @Test
    public void testupdateDormRepair(){
        DormRepair dormRepair = new DormRepair();
        dormRepair.setD_id(105);
        int i = dormRepairDao.updateDormRepair(dormRepair);
        System.out.println(i);
    }

    @Test
    public void testgetAll(){
        List<DormRepair> all = dormRepairDao.getAll();
        System.out.println(all);
    }
}
