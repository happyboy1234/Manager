package com.s1mple.service.impl;

import com.s1mple.dao.StudentCleanDao;
import com.s1mple.dao.StudentDao;
import com.s1mple.entity.PageInfo;
import com.s1mple.entity.StudentClean;
import com.s1mple.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-11:04
 */
@Service("studentCleanService")
@Transactional
public class StudentCleanServiceImpl implements StudentCleanService {

    @Autowired
    private StudentCleanDao studentCleanDao;

    //分页查询
    @Override
    public PageInfo<StudentClean> findPageInfo(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize) {
        PageInfo<StudentClean> pi = new PageInfo<StudentClean>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = studentCleanDao.totalCount(s_studentid,s_name,s_dormitoryid);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<StudentClean> studentCleanList =	studentCleanDao.getStudentCleanList(s_studentid,s_name,s_dormitoryid,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(studentCleanList);
        }
        return pi;
    }

    @Override
    public int addStudentClean(StudentClean studentclean) {
        return studentCleanDao.addStudentClean(studentclean);
    }

    @Override
    public int deleteStudentClean(Integer g_id) {
        return studentCleanDao.deleteStudentClean(g_id);
    }

    @Override
    public int updateStudentClean(StudentClean studentclean) {
        return studentCleanDao.updateStudentClean(studentclean);
    }

    @Override
    public StudentClean findStudentCleanById(Integer g_id) {
        return studentCleanDao.findStudentCleanById(g_id);
    }

    @Override
    public List<StudentClean> getAll() {
        return studentCleanDao.getAll();
    }
}
