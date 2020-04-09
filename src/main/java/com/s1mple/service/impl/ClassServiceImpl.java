package com.s1mple.service.impl;

import com.s1mple.dao.ClassDao;
import com.s1mple.entity.Class;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/7-16:44
 */
@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public PageInfo<Class> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize) {
        PageInfo<Class> pi = new PageInfo<Class>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = classDao.totalCount(c_classname,c_classid,c_counsellor);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示班级信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Class> classList =	classDao.getClassList(c_classname,c_classid,c_counsellor,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(classList);
        }
        return pi;
    }

    @Override
    public int deleteClass(Integer c_id) {
        return classDao.deleteClass(c_id);
    }

    @Override
    public int addClass(Class ucalss) {
        return classDao.addClass(ucalss);
    }

    @Override
    public Class findClassById(Integer c_id) {
        return classDao.findClassById(c_id);
    }

    @Override
    public int updateClass(Class uclass) {
        return classDao.updateClass(uclass);
    }

    @Override
    public List<Class> findClassStudent(Class uclass) {
        return classDao.findClassStudent(uclass);
    }

    @Override
    public List<Class> getAll() {
        return classDao.getAll();
    }
}
