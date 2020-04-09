package com.s1mple.service;

import com.s1mple.BaseTest;
import com.s1mple.entity.Admin;
import com.s1mple.entity.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-15:15
 */
public class AdminServiceTest extends BaseTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testfindAdmin(){
        Admin admin = new Admin();
        admin.setA_username("s1mple");
        Admin admin1 = adminService.findAdmin(admin);
        System.out.println(admin1);
    }

    @Test
    public void testgetAll(){
        List<Admin> all = adminService.getAll();
        System.out.println(all);
    }

    @Test
    public void testfindPageInfo(){
        PageInfo<Admin> pageInfo = adminService.findPageInfo("", "", 1, 1, 1);
        System.out.println(pageInfo);
    }

    @Test
    public void testaddAdmin(){
        Admin admin = new Admin();
        admin.setA_username("s1mple2");
        admin.setA_password("123456");
        int i = adminService.addAdmin(admin);
        System.out.println(i);
    }

    @Test
    public void testdeleteAdmin(){
        int i = adminService.deleteAdmin(11);
        System.out.println(i);
    }

    @Test
    public void testupdateAdmin(){
        Admin admin = new Admin();
        admin.setA_password("123456");
        admin.setA_username("s1mple3");
        admin.setA_id(11);
        int i = adminService.updateAdmin(admin);
        System.out.println(i);
    }

    @Test
    public void testfindAdminById(){
        Admin adminById = adminService.findAdminById(1);
        System.out.println(adminById);
    }
}

