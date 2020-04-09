package com.s1mple.service.impl;

import com.s1mple.dao.VisitorDao;
import com.s1mple.entity.PageInfo;
import com.s1mple.entity.Visitor;
import com.s1mple.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-11:08
 */
@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public PageInfo<Visitor> findPageInfo(String v_name, Integer v_phone , Integer pageIndex, Integer pageSize) {
        PageInfo<Visitor> pi = new PageInfo<Visitor>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = visitorDao.totalCount(v_name,v_phone);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visitor> visitorList =	visitorDao.getVisitorList(v_name,v_phone,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(visitorList);
        }
        return pi;
    }

    @Override
    public int addVisitor(Visitor visitor) {
        return visitorDao.addVisitor(visitor);
    }

    @Override
    public List<Visitor> getAll() {
        return visitorDao.getAll();
    }
}
