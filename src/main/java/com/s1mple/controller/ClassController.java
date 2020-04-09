package com.s1mple.controller;

import com.s1mple.entity.Class;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-16:45
 */
@Controller
public class ClassController {

    @Autowired
    private ClassService classService;

    /**
     * 分页查询
     * @param c_classid
     * @param c_classname
     * @param c_counsellor
     * @param pageIndex 当前页码
     * @param pageSize  显示条数
     * @param model
     * @return
     */
    @RequestMapping(value = "/findClass")
    public String findClass(Integer c_classid, String c_classname, String c_counsellor,
                            Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<Class> pageInfo = classService.findPageInfo(c_classname, c_counsellor, c_classid, pageIndex, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("c_classid", c_classid);
        return "class_list";
    }

    /**
     * 导出Excel
     * @return
     */
    @RequestMapping(value = "/exportclasslist",method = RequestMethod.POST)
    @ResponseBody
    public List<Class> exportClass() {
        List<Class> classList = classService.getAll();
        return classList;
    }

    /**
     * 删除学生信息
     * @param c_id
     * @return
     */
    @RequestMapping("/deleteClass")
    @ResponseBody
    public String deleteClass(Integer c_id) {
        int i = classService.deleteClass(c_id);
        return "class_list";
    }

    @RequestMapping(value = "/addClass",method = RequestMethod.POST)
    @ResponseBody
    public String addClass(@RequestBody Class aclass) {
        int i = classService.addClass(aclass);
        return "class_list";
    }

    /**
     * 根据ID查找班级
     *
     * @param c_id
     * @param session
     * @return
     */
    @RequestMapping("/findClassById")
    public String findClassById(Integer c_id, HttpSession session) {
        Class c = classService.findClassById(c_id);
        session.setAttribute("c", c);
        return "class_edit";
    }

    /**
     * 修改班级信息
     * @param aclass
     * @return
     */
    @RequestMapping(value = "/updateClass",method = RequestMethod.POST)
    @ResponseBody
    public String updateClass(Class aclass) {
        int i = classService.updateClass(aclass);
        return "redirect:/findClass";
    }

    /**
     * 班级人员信息查询
     * @param aclass
     * @param model
     * @return
     */
    @RequestMapping(value = "findClassStudent")
    public String findClassStudent(Class aclass, Model model) {
        List<Class> classStudent = classService.findClassStudent(aclass);
        model.addAttribute("classStudent", classStudent);
        return "class_Studentlist";
    }

    @RequestMapping(value = "/findClassStudentList",method = RequestMethod.POST)
    @ResponseBody
    public List<Class> findClassStudentList(@RequestBody Class aclass) {
        List<Class> c = classService.findClassStudent(aclass);
        return c;
    }
}
