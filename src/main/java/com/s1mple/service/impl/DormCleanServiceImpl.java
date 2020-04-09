package com.s1mple.service.impl;

import com.s1mple.dao.DormCleanDao;
import com.s1mple.entity.Class;
import com.s1mple.entity.DormClean;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-10:39
 */
@Service("dormCleanService")
@Transactional
public class DormCleanServiceImpl implements DormCleanService {

    @Autowired
    private DormCleanDao dormCleanDao;

    //分页查询
    @Override
    public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormClean> pi = new PageInfo<DormClean>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormCleanDao.totalCount(d_id,d_dormbuilding);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormClean> dormCleanList =	dormCleanDao.getDormCleanList(d_id,d_dormbuilding,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormCleanList);
        }
        return pi;
    }

    @Override
    public int addDormClean(DormClean dormclean) {
        return dormCleanDao.addDormClean(dormclean);
    }

    @Override
    public int deleteDormClean(Integer g_id) {
        return dormCleanDao.deleteDormClean(g_id);
    }

    @Override
    public int updateDormClean(DormClean dormclean) {
        return dormCleanDao.updateDormClean(dormclean);
    }

    @Override
    public DormClean findDormCleanById(Integer g_id) {
        return dormCleanDao.findDormCleanById(g_id);
    }

    @Override
    public List<DormClean> getAll() {
        return dormCleanDao.getAll();
    }
}
