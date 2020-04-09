package com.s1mple.controller;

import com.s1mple.entity.DormClean;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-17:27
 */
@Controller
public class DormCleanController {


    @Autowired
    private DormCleanService dormCleanService;

    /**
     * 分页查询
     * @param d_id
     * @param d_dormbuilding
     * @param pageIndex 当前页码
     * @param pageSize  显示条数
     * @param model
     * @return
     */
    @RequestMapping(value = "/findDormClean")
    public String findDormClean(Integer d_id, String d_dormbuilding,
                                Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<DormClean> di = dormCleanService.findPageInfo(d_id, d_dormbuilding, pageIndex, pageSize);
        model.addAttribute("di", di);
        return "dormclean_list";
    }

    /**
     * 导出Excel
     * @return
     */
    @RequestMapping(value = "/exportdormcleanlist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormClean> exportDormclean(){
        List<DormClean> dormclean = dormCleanService.getAll();
        return dormclean;
    }

    /**
     * 添加宿舍卫生信息
     * @param dormClean
     * @return
     */
    @RequestMapping(value = "/addDormClean", method = RequestMethod.POST)
    @ResponseBody
    public String addDormClean(DormClean dormClean) {
        int d = dormCleanService.addDormClean(dormClean);
        return "dormclean_list";
    }

    /**
     * 修改宿舍卫生信息
     * @param dormClean
     * @return
     */
    @RequestMapping("/updateDormClean")
    public String updateDormClean(DormClean dormClean) {
        int i = dormCleanService.updateDormClean(dormClean);
        return "redirect:/findDormClean";
    }

    @RequestMapping("/findDormCleanById")
    public String findDormCleanById(Integer g_id, HttpSession session) {
        DormClean d = dormCleanService.findDormCleanById(g_id);
        session.setAttribute("d", d);
        return "dormclean_edit";
    }
}
