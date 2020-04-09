package com.s1mple.service;

import com.s1mple.entity.DormClean;
import com.s1mple.entity.PageInfo;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:37
 */
public interface DormCleanService {

    /**
     *分頁查詢
     * @param d_id
     * @param d_dormbuilding
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize);

    /**
     *  添加宿舍信息
     * @param dormclean
     * @return
     */
    public int addDormClean(DormClean dormclean);

    /**
     * 删除宿舍信息
     * @param g_id
     * @return
     */
    public int deleteDormClean(Integer g_id);

    /**
     * 修改宿舍信息
     * @param dormclean
     * @return
     */
    public int updateDormClean(DormClean dormclean);

    public DormClean findDormCleanById(Integer g_id);

    public List<DormClean> getAll();
}
