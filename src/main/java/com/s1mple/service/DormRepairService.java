package com.s1mple.service;

import com.s1mple.entity.DormRepair;
import com.s1mple.entity.PageInfo;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:39
 */
public interface DormRepairService {
    /**
     *  分页查询
     * @param d_id
     * @param d_dormbuilding
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize);

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
     *  修改宿舍信息
     * @param dormrepair
     * @return
     */
    public int updateDormRepair(DormRepair dormrepair);

    public DormRepair findDormRepairById(Integer r_id);

    public List<DormRepair> getAll();

}
