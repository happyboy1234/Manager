package com.s1mple.dao;

import com.s1mple.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 * @author s1mple
 * @create 2020/4/5-16:58
 */
public interface AdminDao {

    /**
     * 通过账号和密码查询管理员
     * @param admin
     * @return
     */
    public Admin findAdmin(Admin admin);

    /**
     * 获取总条数
     * @param a_username
     * @param a_describe
     * @param a_id
     * @return
     */
    public Integer totalCount(@Param("a_username") String a_username, @Param("a_describe") String a_describe,@Param("a_id") Integer a_id);

    /**
     * 获取用户列表
     * @param a_username
     * @param a_describe
     * @param a_id
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Admin> getAdminList(@Param("a_username") String a_username, @Param("a_describe") String a_describe,@Param("a_id") Integer a_id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     * 添加管理员信息
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
     * 修改管理员信息
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin);

    /**
     * 通过ID查找管理员
     * @param a_id
     * @return
     */
    public Admin findAdminById(Integer a_id);

    /**
     * 获取所有管理员信息
     * @return
     */
    public List<Admin> getAll();

}
