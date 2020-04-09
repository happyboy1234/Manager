package com.s1mple.service.impl;

import com.s1mple.dao.DormitoryDao;
import com.s1mple.entity.Dormitory;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-10:48
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryDao dormitoryDao;


    //分页查询
    @Override
    public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid,String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormitoryDao.totalCount(a_name,s_dormitoryid,d_dormbuilding);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Dormitory> dormitoryList =	dormitoryDao.getDormitoryList(a_name,s_dormitoryid,d_dormbuilding,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormitoryList);
        }
        return pi;
    }

    @Override
    public int addDormitory(Dormitory dormitory) {
        return dormitoryDao.addDormitory(dormitory);
    }

    @Override
    public int deleteDormitory(Integer d_id) {
        return dormitoryDao.deleteDormitory(d_id);
    }

    @Override
    public int updateDormitory(Dormitory dormitory) {
        return dormitoryDao.updateDormitory(dormitory);
    }

    @Override
    public Dormitory findDormitoryById(Integer d_id) {
        return dormitoryDao.findDormitoryById(d_id);
    }

    @Override
    public List<Dormitory> findDormitoryStudent(Dormitory dormitory) {
        return dormitoryDao.findDormitoryStudent(dormitory);
    }

    @Override
    public List<Dormitory> getAll() {
        return dormitoryDao.getAll();
    }
}
