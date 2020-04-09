package com.s1mple.service.impl;

import com.s1mple.dao.StudentDao;
import com.s1mple.entity.PageInfo;
import com.s1mple.entity.Student;
import com.s1mple.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-11:06
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid,Integer s_classid,
                                          String s_classname, Integer pageIndex, Integer pageSize) {
        PageInfo<Student> pi = new PageInfo<Student>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = studentDao.totalCount(s_name,s_studentid,s_classid,s_classname);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Student> studentList =	studentDao.getStudentList(s_name,s_studentid,s_classid,s_classname,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(studentList);
        }
        return pi;
    }

    @Override
    public int deleteStudent(Integer s_id) {
        return studentDao.deleteStudent(s_id);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student findStudentById(Integer s_id) {
        return studentDao.findStudentById(s_id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
