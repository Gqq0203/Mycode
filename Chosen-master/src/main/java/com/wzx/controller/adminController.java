package com.wzx.controller;

import com.wzx.Pojo.Admin;
import com.wzx.Pojo.Notice;
import com.wzx.Service.AdminService;
import com.wzx.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;
    @Autowired
    @Qualifier("NoticeServiceImpl")
    private NoticeService noticeService;

    @RequestMapping("/toLoginAdmin")
    public String toLoginPage(){
        return "loginAdmin";
    }

    @RequestMapping("/loginAdmin")//管理员密码验证
    public String loginAdmin(String name, String password, Model model, HttpSession session){
        Admin admin=adminService.queryAdminByName(name);
        if(admin==null){
//            model.addAttribute("loginError","0");
            session.setAttribute("loginError","用户名或密码错误");
            return "loginAdmin";
        }else if (!admin.getPassword().equals(password)){
            session.setAttribute("loginError","用户名或密码错误");
//            model.addAttribute("loginError","0");
            return "loginAdmin";
        }else{
            model.addAttribute("user",admin);
            return "adminView";
        }
    }

    @RequestMapping("toNoticeView")
    public String toNoticePage(Model model){
        List<Notice> list=noticeService.queryAllNotice();
        model.addAttribute("list",list);
        return "noticeView";
    }
    @RequestMapping("toStudentNotice")
    public String toStudentNotice(Model model){
        List<Notice> list=noticeService.queryAllNotice();
        System.out.println("list");
        model.addAttribute("list",list);
        return "studentNotice";
    }
    @RequestMapping("toTeacherNotice")
    public String toTeacherNotice(Model model){
        List<Notice> list=noticeService.queryAllNotice();
        model.addAttribute("list",list);
        return "teacherNotice";
    }
    @RequestMapping("toAddtNotice")
    public String toInsertNotice(Notice notice){

        return "addNotice";
    }
    @RequestMapping("addNotice")
    public String addNotice(Notice notice){
        Date date=new Timestamp(System.currentTimeMillis());
        notice.setTime(date);
        noticeService.addNotice(notice);
        return "redirect:/admin/toNoticeView";
    }
    @RequestMapping("deleteNotice")
    public String deleteNotice(int id){
        noticeService.deleteNoticeById(id);
        return "redirect:/admin/toNoticeView";
    }
    @RequestMapping("toUpdateNotice")
    public String toUpdateNotice(int id,Model model){
        Notice notice=noticeService.queryNoticeById(id);
        model.addAttribute("notice",notice);
        return "updateNotice";
    }
    @RequestMapping("updateNotice")
    public String updateNotice(Notice notice){
        System.out.println(notice.getId());
        Date date=new Timestamp(System.currentTimeMillis());
        notice.setTime(date);
        noticeService.updateNotice(notice);
        return "redirect:/admin/toNoticeView";
    }

}
