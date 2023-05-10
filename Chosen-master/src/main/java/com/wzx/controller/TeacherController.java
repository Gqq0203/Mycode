package com.wzx.controller;

import com.wzx.Pojo.Register;
import com.wzx.Pojo.Teacher;
import com.wzx.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    @Autowired
    @Qualifier("RegisterServiceImpl")
    private RegisterService registerService;
    @Autowired
    @Qualifier("FirstRegisterServiceImpl")
    private FirstRegisterService firstRegisterService;
    @Autowired
    @Qualifier("SecondRegisterServiceImpl")
    private SecondRegisterService secondRegisterService;
    @Autowired
    @Qualifier("ThirdRegisterServiceImpl")
    private ThirdRegisterService thirdRegisterService;

    //跳转到登录界面
    @RequestMapping("/toLoginTeacher")
    public String toLoginPage(){
        return "loginTeacher";
    }
    //登录验证，跳转到教师界面
    @RequestMapping("/loginTeacher")
    public String loginTeacher(String tno, Model model, String password, HttpSession session){
        Teacher teacher=teacherService.selectTeacherById(tno);
        if(teacher==null){
//            model.addAttribute("loginError","0");
            session.setAttribute("loginError","用户名或密码错误");
            return "loginTeacher";
        }else if (!teacher.getPassword().equals(password)){
//            model.addAttribute("loginError","0");
            session.setAttribute("loginError","用户名或密码错误");
            return "loginTeacher";
        }else{
//            List<Student> list =studentService.queryAllStudent();
//            model.addAttribute("list",list);
//            model.addAttribute("user",teacher);
//            return "teacherView";
            session.setAttribute("teacher",teacher);
            return "leftTeacher";
        }
    }
    //显示
    @RequestMapping("/toTeacherView")
    public String toTeacherView(String tno, Model model){
        //查询三个志愿中所有与该教师有关的register信息，返回到teacherView
        int j;
        List<Register> registerList=new ArrayList<Register>();
        List<Student> studentList=new ArrayList<Student>();
        List<Register> list1=firstRegisterService.queryRegisterByTno(tno);
        for ( j=0;j<list1.size();j++){
            Register register=list1.get(j);
            if (register.getState()==0){
                //如果第一志愿未选择就显示出来。
                registerList.add(register);
            }
        }

        List<Register> list2=secondRegisterService.queryRegisterByTno(tno);
        for ( j=0;j<list2.size();j++){
            Register register=list2.get(j);
            Register register1=firstRegisterService.queryRegisterById(register.rid);
            if (register1.getState()==2){
                //状态为2代表已拒绝，显示出来已拒绝信息
                registerList.add(register);
            }
        }
        List<Register> list3=thirdRegisterService.queryRegisterByTno(tno);
        for ( j=0;j<list3.size();j++){
            Register register=list3.get(j);
            Register register1=firstRegisterService.queryRegisterById(register.rid);
            Register register2=secondRegisterService.queryRegisterById(register.rid);
            if (register1.getState()==2 && register2.getState()==2){
                //状态为2代表已拒绝，显示出来已拒绝信息
                registerList.add(register);
            }
        }

        model.addAttribute("registerList",registerList);
        for (int i=0;i<registerList.size();i++){
            String sno=registerList.get(i).getSno();
            Student student=studentService.queryById(sno);
            studentList.add(student);
        }
        model.addAttribute("studentList",studentList);
        return "teacherView";
    }
    //查询所有教师信息，并返回到一个教师展示界面
    @RequestMapping("/allTeacher")
    public String list(Model model){
        List<Teacher> list=teacherService.selectAllTeacher();
        model.addAttribute("list",list);
        return "allTeacher";
    }
    //跳转到增加教师页面
    @RequestMapping("/toAddTeacher")
    public String toAddPage(){
        return "addTeacher";
    }
    @RequestMapping("addTeacher")
    public String AddTeacher(Teacher teacher){
        System.out.println(teacher);
        teacherService.addTeacher(teacher);
        return "redirect:/teacher/allTeacher";
    }
    //admin:跳转到修改教师信息页面
    @RequestMapping("/toUpdateTeacher")
    public String toUpdatePage(String id,Model model){
        Teacher teacher=teacherService.selectTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "updateTeacher";
    }
    //admin:修改教师信息
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher/allTeacher";
    }
    //teacher:跳转到修改教师信息页面
    @RequestMapping("/toModifyTeacher")
    public String toModifyPage(String tno,Model model){
        Teacher teacher=teacherService.selectTeacherById(tno);
        model.addAttribute("teacher",teacher);
        return "modifyTeacher";
    }
    //teacher:修改教师信息
    @RequestMapping("/modifyTeahcer")
    public String modifyTeahcer(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher/toTeacherView?tno="+teacher.getTno();
    }

    //admin删除教师信息
    @RequestMapping("/deleteTeacher/{tno}")
    public String deleteTeacher(@PathVariable("tno") String tno){
        int i=teacherService.delectTeacherById(tno);
        System.out.println(i);
        return "redirect:/teacher/allTeacher";
    }
    //删除reigster
    @RequestMapping("/deleteRegisterByTeach/{rid}")
    public String deleteRegisterByTeach(@PathVariable("rid") int rid,HttpSession session){
        registerService.deleteRegisterById(rid);
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        return "redirect:/teacher/toTeacherRegisted?tno="+teacher.getTno();
    }

    //前往老师已经选择的学生页面
    @RequestMapping("toTeacherRegisted")
    public  String toTeacherRegisted(String tno,Model model){
        List<Register> list=registerService.queryRegisterByTno(tno);
        List<Student> Slist=new ArrayList<Student>();
        model.addAttribute("list",list);
        for (int i=0;i<list.size();i++){
            Register register1=list.get(i);
            String sno=register1.getSno();
            Student student=studentService.queryById(sno);
            Slist.add(student);
        }
        model.addAttribute("Slist",Slist);
        return "teacherRegister";
    }
    //老师选择学生
    @RequestMapping("/addTeacherRegister/{tno}/{sno}/{rid}/{able}/{time}")
    public String addRegister(@PathVariable("sno") String sno, @PathVariable("tno") String tno, @PathVariable("rid") int rid, @PathVariable("able") int able, @PathVariable("time") Date date, HttpSession session){
        if (teacherService.selectTeacherById(tno).getState()<=registerService.queryRegisterByTno(tno).size()) {
            session.setAttribute("tmsg","您当前学生人数已上限！");
            return "redirect:/teacher/toTeacherView?tno="+tno;
        }
        Register register=new Register();
        register.setTno(tno);
        register.setSno(sno);
        register.setState(1);
        register.setAble(able);
        register.setTime(date);
        registerService.addRegister(register);
        firstRegisterService.deleteRegisterById(rid);
        secondRegisterService.deleteRegisterById(rid);
        thirdRegisterService.deleteRegisterById(rid);
        //更新学生状态码
        Student student=studentService.queryById(sno);
        student.setState(1);
        studentService.updateStudent(student);
        return "redirect:/teacher/toTeacherRegisted?tno="+tno;
    }
    //老师拒绝学生
    @RequestMapping("/refuseStudent/{rid}/{able}/{sno}")
    public String refuseStudent(@PathVariable("rid") int rid,@PathVariable("able") int able,@PathVariable("sno") String sno,HttpSession session){
        Register register;
        int Num=studentService.queryById(sno).getNum();
        if (able==1){
            register=firstRegisterService.queryRegisterById(rid);
            register.setState(2);
            firstRegisterService.updateRegister(register);
        }else if (able==2){
            register=secondRegisterService.queryRegisterById(rid);
            register.setState(2);
            secondRegisterService.updateRegister(register);
        }else if (able==3){
            register=thirdRegisterService.queryRegisterById(rid);
            register.setState(2);
            thirdRegisterService.updateRegister(register);
        }
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        //更新学生的预约数
        Num--;
        Student student=studentService.queryById(sno);
        student.setNum(Num);
        studentService.updateStudent(student);
        return "redirect:/teacher/toTeacherView?tno="+teacher.getTno();
    }
    //前往注册界面
    @RequestMapping("/toUserTeacher")
    public String toUserTeacher(){
        return "userTeacher";
    }
    //教师注册
    @RequestMapping("/userTeacher")
    public String userTeacher(Teacher teacher){
        teacherService.addTeacher(teacher);
        return "loginTeacher";
    }
//    //更改状态码为1
//    @RequestMapping("/acceptTeacher")
//    public String acceptTeacher( int rid,int able){
//        Register register=null;
//        if (able==1){
//            register=firstRegisterService.queryRegisterById(rid);
//        } else if (able==2) {
//            register=secondRegisterService.queryRegisterById(rid);
//        }else{
//            register=thirdRegisterService.queryRegisterById(rid);
//        }
//        registerService.addRegister(register);
//
////        Register register=registerService.queryRegisterById(rid);
////        register.setState(1);
////        registerService.updateRegister(register);
//        return "redirect:/teacher/toTeacherRegisted?tno="+register.getTno();
//    }
}
