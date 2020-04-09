package com.s1mple.dao;

import com.s1mple.BaseTest;
import com.s1mple.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/5-17:22
 */
public class AdminDaoTest extends BaseTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void testFindAdmin(){
        Admin admin = new Admin();
        admin.setA_username("s1mple");
        Admin admin1 = adminDao.findAdmin(admin);
        System.out.println(admin1);
    }

    @Test
    public void testGetAll(){
        List<Admin> all = adminDao.getAll();
        System.out.println(all);
    }

    @Test
    public void testTotalCount(){
        Integer count = adminDao.totalCount("s1mple", "s1mple", 13);
        System.out.println(count);
    }

    @Test
    public void testGetAdminList(){
        List<Admin> s1mple = adminDao.getAdminList("s1mple", "", 1, 1, 1);
        System.out.println(s1mple);
    }

    @Test
    public void testaddAdmin(){
        Admin admin = new Admin();
        admin.setA_username("Niko");
        admin.setA_password("asd12345");
        int i = adminDao.addAdmin(admin);
        System.out.println(i);
    }

    @Test
    public void testdeleteAdmin(){
        int i = adminDao.deleteAdmin(14);
        System.out.println(i);
    }

    @Test
    public void testupdateAdmin(){
        Admin admin = new Admin();
        admin.setA_username("Niko");
        admin.setA_password("1");
        admin.setA_describe("csgo");
        admin.setA_id(1);
        int i = adminDao.updateAdmin(admin);
        System.out.println(i);
    }

    @Test
    public void testfindAdminById(){
        Admin admin = adminDao.findAdminById(1);
        System.out.println(admin);
    }
}
