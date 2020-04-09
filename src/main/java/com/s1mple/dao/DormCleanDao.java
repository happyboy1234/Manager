package com.s1mple.dao;

import com.s1mple.entity.DormClean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 宿舍卫生
 * @author s1mple
 * @create 2020/4/6-15:39
 */
public interface DormCleanDao {

    /**
     *  获取总条数
     * @param d_id
     * @param d_dormbuilding
     * @return
     */
    public Integer totalCount(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding);

    /**
     * 获取用户列表
     * @param d_id
     * @param d_dormbuilding
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<DormClean> getDormCleanList(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     * 添加宿舍卫生信息
     * @param dormclean
     * @return
     */
    public int addDormClean(DormClean dormclean);

    /**
     * 删除宿舍卫生信息
     * @param g_id
     * @return
     */
    public int deleteDormClean(Integer g_id);

    /**
     * 修改宿舍卫生信息
     * @param dormclean
     * @return
     */
    public int updateDormClean(DormClean dormclean);

    public DormClean findDormCleanById(Integer g_id);

    public List<DormClean> getAll();

}
