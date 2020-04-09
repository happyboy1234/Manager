package com.s1mple.dao;

import com.s1mple.entity.DormRepair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 维修登记
 * @author s1mple
 * @create 2020/4/6-15:42
 */
public interface DormRepairDao {
    /**
     * 获取总条数
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
    public List<DormRepair> getDormRepairList(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     *  添加宿舍信息
     * @param dormrepair
     * @return
     */
    public int addDormRepair(DormRepair dormrepair);

    /**
     *  删除宿舍信息
     * @param r_id
     * @return
     */
    public int deleteDormRepair(Integer r_id);

    /**
     * 修改宿舍信息
     * @param dormrepair
     * @return
     */
    public int updateDormRepair(DormRepair dormrepair);

    public DormRepair findDormRepairById(Integer r_id);

    public List<DormRepair> getAll();
}
