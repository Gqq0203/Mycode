package com.wzx.controller;

import com.wzx.Pojo.Register;
import com.wzx.Service.RegisterService;
import com.wzx.Service.StudentService;
import com.wzx.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*记录*/
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    @Qualifier("RegisterServiceImpl")
    private RegisterService registerService;
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;

    @RequestMapping("/toAddRegister")
    public String toAddRegister(){
        return "addRegister";
    }
    @RequestMapping("/addRegister")
    public String addRegister(Register register){
        registerService.addRegister(register);
        return "redirect:/register/allRegister";
    }
    //查看所有记录
    @RequestMapping("/allRegister")
    public String allRegister(Model model){
        List<Register> list =registerService.queryRegister();
        model.addAttribute("list",list);
        return "allRegister";
    }
    //前往修改记录界面
    @RequestMapping("/toUpdateRegister/{rid}")
    public String toUpdateRegister(@PathVariable("rid") int rid, Model model){
        Register register=registerService.queryRegisterById(rid);
        model.addAttribute("register",register);
        return "updateRegister";
    }
    //修改记录
    @RequestMapping("/updateRegister")
    public String updateRegister(Register register){
        registerService.updateRegister(register);
        return "redirect:/register/allRegister";
    }
    //删除记录
    @RequestMapping("/deleteRegister/{rid}/{sno}")
    public String deleteRegister(@PathVariable("rid") int rid,@PathVariable("sno") String sno){
        registerService.deleteRegisterById(rid);
        Student student=studentService.queryById(sno);
        student.setState(0);
        studentService.updateStudent(student);
        return "redirect:/register/allRegister";
    }
}
