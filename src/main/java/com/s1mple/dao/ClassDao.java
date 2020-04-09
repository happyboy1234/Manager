package com.s1mple.dao;

import com.s1mple.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/5-22:44
 */
public interface ClassDao {
    /**
     * 获取总条数
     * @param c_classname
     * @param c_classid
     * @param c_counsellor
     * @return
     */
    public Integer totalCount(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor);

    /**
     * 获取用户列表
     * @param c_classname
     * @param c_classid
     * @param c_counsellor
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Class> getClassList(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /**
     * 删除班级信息
     * @param c_id
     * @return
     */
    public int deleteClass(Integer c_id);

    /**
     * 添加班级信息
     * @param ucalss
     * @return
     */
    public int addClass(Class ucalss);

    /**
     * 修改班级信息
     * @param uclass
     * @return
     */
    public int updateClass(Class uclass);


    public Class findClassById(Integer c_id);

    /**
     * 查询班级人员信息
     * @param uclass
     * @return
     */
    public List<Class> findClassStudent(Class uclass);

    public List<Class> getAll();
}
