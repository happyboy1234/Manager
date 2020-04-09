package com.s1mple.service;

import com.s1mple.entity.Class;
import com.s1mple.entity.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/6-16:36
 */
public interface ClassService {

    /**
     *  分页查询
     * @param c_classname
     * @param c_counsellor
     * @param c_classid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Class> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize);

    /**
     *  删除班级信息
     * @param c_id
     * @return
     */
    public int deleteClass(Integer c_id);

    /**
     *  添加班级信息
     * @param ucalss
     * @return
     */
    public int addClass(Class ucalss);

    public Class findClassById(Integer c_id);

    /**
     * 修改班级信息
     * @param uclass
     * @return
     */
    public int updateClass(Class uclass);

    /**
     * 查询班级人员信息
     * @param uclass
     * @return
     */
    public List<Class> findClassStudent(Class uclass);

    public List<Class> getAll();

}
