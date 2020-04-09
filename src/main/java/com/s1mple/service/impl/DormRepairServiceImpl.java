package com.s1mple.service.impl;

import com.s1mple.dao.DormRepairDao;
import com.s1mple.entity.DormRepair;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-11:00
 */
@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements DormRepairService {

    @Autowired
    private DormRepairDao dormRepairDao;

    //分页查询
    @Override
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormRepair> pi = new PageInfo<DormRepair>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormRepairDao.totalCount(d_id,d_dormbuilding);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormRepair> dormRepairList =	dormRepairDao.getDormRepairList(d_id,d_dormbuilding,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormRepairList);
        }
        return pi;
    }

    @Override
    public int addDormRepair(DormRepair dormrepair) {
        return dormRepairDao.addDormRepair(dormrepair);
    }

    @Override
    public int deleteDormRepair(Integer r_id) {
        return dormRepairDao.deleteDormRepair(r_id);
    }

    @Override
    public int updateDormRepair(DormRepair dormrepair) {
        return dormRepairDao.updateDormRepair(dormrepair);
    }

    @Override
    public DormRepair findDormRepairById(Integer r_id) {
        return dormRepairDao.findDormRepairById(r_id);
    }

    @Override
    public List<DormRepair> getAll() {
        return dormRepairDao.getAll();
    }
}
