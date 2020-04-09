package com.s1mple.service;

import com.s1mple.BaseTest;
import com.s1mple.entity.DormClean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-15:24
 */
public class DormCleanServiceTest extends BaseTest {

    @Autowired
    private DormCleanService dormCleanService;

    @Test
    public void findPageInfo() {
    }

    @Test
    public void addDormClean() {
        DormClean dormClean = new DormClean();
        dormClean.setD_grade(91);
        dormClean.setD_dormbuilding("摩天大厦");
        dormClean.setD_id(911);
        int i = dormCleanService.addDormClean(dormClean);
        System.out.println(i);
    }

    @Test
    public void deleteDormClean() {
        int i = dormCleanService.deleteDormClean(111);
        System.out.println(i);
    }

    @Test
    public void updateDormClean() {
        DormClean dormClean = new DormClean();
        dormClean.setD_id(47);
        dormClean.setD_dormbuilding("预计大厦");
        dormClean.setD_id(811);
        int i = dormCleanService.updateDormClean(dormClean);
        System.out.println(i);
    }

    @Test
    public void findDormCleanById() {
        DormClean clean = dormCleanService.findDormCleanById(7);
        System.out.println(clean);
    }

    @Test
    public void getAll() {
        List<DormClean> all = dormCleanService.getAll();
        System.out.println(all);
    }
}
