package com.s1mple.service.impl;

import com.s1mple.dao.AdminDao;
import com.s1mple.entity.Admin;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 * @author s1mple
 * @create 2020/4/6-16:43
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    /**
     * 管理登陆查询
     * @param admin
     * @return
     */
    @Override
    public Admin findAdmin(Admin admin) {
        Admin a = adminDao.findAdmin(admin);
        return a;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> all = adminDao.getAll();
        return all;
    }

    @Override
    public PageInfo<Admin> findPageInfo(String a_username, String a_describe, Integer a_id, Integer pageIndex, Integer pageSize) {
        PageInfo<Admin> pageInfo = new PageInfo<Admin>();
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = adminDao.totalCount(a_username, a_describe, a_id);
        if (totalCount > 0) {
            pageInfo.setTotalCount(totalCount);
            /*每一页显示管理员信息数*/
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Admin> adminList =	adminDao.getAdminList(a_username,a_describe,a_id,
                    (pageInfo.getPageIndex()-1)*pageInfo.getPageSize(),pageInfo.getPageSize());
            pageInfo.setList(adminList);
        }
        return null;
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(Integer a_id) {
        return adminDao.deleteAdmin(a_id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Admin findAdminById(Integer a_id) {
        return adminDao.findAdminById(a_id);
    }
}
