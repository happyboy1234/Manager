package com.s1mple.controller;

import com.s1mple.entity.Admin;
import com.s1mple.entity.PageInfo;
import com.s1mple.service.AdminService;
import com.s1mple.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author s1mple
 * @create 2020/4/8-13:37
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     *  用户登陆
     *  将提交的数据(username,password)写入到admin对象中
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Admin admin, Model model, HttpSession session, HttpServletRequest request) {
        /*通过账号和密码查询用户 */
        admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        Admin ad = adminService.findAdmin(admin);
        if (ad != null) {
            session.setAttribute("ad", ad);
            return "homepage";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新输入！");
        return "login";
    }

    /**
     *  退出登录
     * @param admin
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/loginout")
    public String loginOut(Admin admin, Model model, HttpSession httpSession) {
        /*使该Session无效
          将该Session绑定的对象全部解绑
        */
        httpSession.invalidate();
        return "login";
    }

    /**
     * 分页查询
     * @param a_username
     * @param a_describe
     * @param pageIndex
     * @param a_id
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAdmin")
    public String findAdmin(String a_username, String a_describe, Integer pageIndex,
                            Integer a_id, Integer pageSize, Model model) {
        PageInfo<Admin> pageInfo = adminService.findPageInfo(a_username, a_describe, pageIndex, a_id, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "admin_list";
    }

    /**
     * 导出excel
     * @return
     */
    @RequestMapping(value = "/exportadminlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Admin> exportAdmin() {
        List<Admin> all = adminService.getAll();
        return all;
    }

    /**
     *添加管理员信息
     * @param admin
     * @return
     */
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    @ResponseBody
    public String addAdmin(@RequestBody Admin admin) {
        admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int i = adminService.addAdmin(admin);
        return "admin_list";
    }

    /**
     * 删除管理员信息；将请求体a_id写入参数a_id
     * @param a_id
     * @return
     */
    @RequestMapping(value = "/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(Integer a_id) {
        int i = adminService.deleteAdmin(a_id);
        return "admin_list";
    }

    /**
     * 修改管理员信息
     * 将提交数据(a_id,a_username...)写入Admin对象
     * @param admin
     * @return
     */
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    public String updateAdmin(Admin admin) {
        admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int i = adminService.updateAdmin(admin);
        return "redirect:/findAdmin";
    }

    /**
     * 跟进管理员ID搜索；将请求数据a_id写入参数a_id
     * @param a_id
     * @param session
     * @return
     */
    @RequestMapping("/findAdminById")
    public String findAdminById(Integer a_id, HttpSession session) {
        Admin admin = adminService.findAdminById(a_id);
        session.setAttribute("admin",admin);
        return "admin_edit";
    }
}
