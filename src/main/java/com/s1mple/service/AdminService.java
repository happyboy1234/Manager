package com.s1mple.service;

import com.s1mple.entity.Admin;
import com.s1mple.entity.PageInfo;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:34
 */
public interface AdminService {
    /**
     * 通过账号和密码查询用户
     * @param admin
     * @return
     */
    public Admin findAdmin(Admin admin);

    /**
     *  找到所有所有数据
     * @return
     */
    public List<Admin> getAll();

    /**
     *  分页查询
     * @param a_username
     * @param a_describe
     * @param a_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Admin> findPageInfo(String a_username, String a_describe, Integer a_id, Integer pageIndex, Integer pageSize);

    /**
     *  添加管理员信息
     * @param admin
     * @return
     */
    public int addAdmin(Admin admin);

    /**
     * 删除管理员信息
     * @param a_id
     * @return
     */
    public int deleteAdmin(Integer a_id);

    /**
     *  修改管理员信息
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin);

    public Admin findAdminById(Integer a_id);

}