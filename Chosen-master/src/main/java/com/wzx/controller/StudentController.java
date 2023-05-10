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
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    //controler调service层
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;
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
    @RequestMapping("/toLoginStudent")
    public String toLoginPage(){
        return "loginStudent";
    }
    //根据id查询学生信息，完成登录检验,登陆后查询可选择的教师信息
    @RequestMapping("/loginStudent")
    public String loginStudent(String sno,String password,Model model,HttpSession session){
        Student student=studentService.queryById(sno);
        if(student==null){
//            model.addAttribute("loginError","0");
            session.setAttribute("loginError","密码或用户名错误");
            return "loginStudent";
        }else if (!student.getPassword().equals(password)){
//            model.addAttribute("loginError","0");
            session.setAttribute("loginError","密码或用户名错误");
            return "loginStudent";
        }else{
//            model.addAttribute("student",student);
            session.setAttribute("student",student);
            return "leftStudent";

//            List<Teacher> list=teacherService.selectAllTeacher();
//            List<Register> registerList=registerService.queryRegisterBySno(sno);
//            for (int i=0;i<registerList.size();i++){
//                Register register=registerList.get(i);
//                String tno=register.getTno();
//                for (int j=0;j<list.size();j++){
//                    Teacher teacher=list.get(j);
//                    if (teacher.getTno().equals(tno)) {
//                        list.remove(teacher);
//                    }
//                }
//            }
//            model.addAttribute("list",list);
//            System.out.println(list.iterator().next());
//            model.addAttribute("user",student);
//            return "studentView";
        }
    }
    @RequestMapping("/toStudentView")//选择导师页面
        public String toStudentView(String sno, Model model){
            List<Teacher> list=teacherService.selectAllTeacher();
            model.addAttribute("list",list);
            return "studentView";
        }

    //查询所有学生信息，并返回到一个学生展示界面
    @RequestMapping("/allStudent")
    public String list(Model model){
        List<Student> list=studentService.queryAllStudent();
        model.addAttribute("list",list);
        return "allStudent";
    }
    //跳转到增加学生页面
    @RequestMapping("/toAddStudent")
    public String toAddPage(){
        return "addStudent";
    }
    @RequestMapping("addStudent")
    public String AddStudent(Student student){
        System.out.println(student);
        studentService.addStudent(student);
        return "redirect:/student/allStudent";
    }
    //admin:跳转到修改学生信息页面
    @RequestMapping("/toUpdateStudent")
    public String toUpdatePage(String id,Model model){
        Student student=studentService.queryById(id);
        model.addAttribute("student",student);
        return "updateStudent";
    }
    //admin:修改学生信息
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/student/allStudent";
    }
    //student:跳转到修改学生信息页面
    @RequestMapping("/toModifyStudent")
    public String toModifyPage(String sno,Model model){
        System.out.println(model);
        Student student=studentService.queryById(sno);
        model.addAttribute("student",student);
        return "modifyStudent";
    }
    //student:修改学生信息
    @RequestMapping("/modifyStudent")
    public String modifyStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/student/toStudentView?sno="+student.getSno();
    }
   /* //删除学生信息
    @RequestMapping("/deleteStudent/{sno}")
    public String deleteStudent(@PathVariable("sno") String sno){
        int i=studentService.deleteStudentById(sno);
        System.out.println(i);
        return "redirect:/student/allStudent";
    }
*/
    //前往学生已经选择的导师页面
    @RequestMapping("toStudentRegisted")
    public  String toStudentRegisted(String sno,Model model){

//        List<Register> list=registerService.queryRegisterBySno(sno);
//        List<Teacher> Tlist=new ArrayList<Teacher>();
//        model.addAttribute("list",list);
//        for (int i=0;i<list.size();i++){
//            Register register1=list.get(i);
//            String teacherno=register1.getTno();
//            Teacher teacher=teacherService.selectTeacherById(teacherno);
//            Tlist.add(teacher);
//        }
//        model.addAttribute("Tlist",Tlist);
        List<Register> registerList=firstRegisterService.queryRegisterBySno(sno);
        List<Teacher> teachersList=new ArrayList<Teacher>();
        registerList.addAll(secondRegisterService.queryRegisterBySno(sno));
        registerList.addAll(thirdRegisterService.queryRegisterBySno(sno));
        if (registerList.isEmpty()){
            registerList.addAll(registerService.queryRegisterBySno(sno));
        }
        for (int i=0;i<registerList.size();i++){
            String tno=registerList.get(i).getTno();
            Teacher teacher=teacherService.selectTeacherById(tno);
            teachersList.add(teacher);
        }
        model.addAttribute("registerList",registerList);
        model.addAttribute("teachersList",teachersList);
        return "studentRegister";
    }
    /*
    //删除reigster
    @RequestMapping("/deleteRegisterByStu/{rid}")
    public String deleteRegisterByStu(@PathVariable("rid") int rid,HttpSession session){
        registerService.deleteRegisterById(rid);
        Student student=(Student)session.getAttribute("student");

        return "redirect:/student/toStudentRegisted?sno="+student.getSno();
    }*/
    //学生选择老师
    @RequestMapping("/addStudentRegister/{sno}/{tno}")
    public String addRegister(@PathVariable("sno") String sno,@PathVariable("tno") String tno){

        Register register =new Register();
        register.setTno(tno);
        register.setSno(sno);
        register.setState(0);//0表示学生单方请求 1表示教师同意
        registerService.addRegister(register);
        return "redirect:/student/toStudentRegisted?sno="+sno;
    }

    //前往注册界面
    @RequestMapping("/toUserStudent")
    public String toUserStudent(){
        return "userStudent";
    }
    //学生注册
    @RequestMapping("/userStudent")
    public String userStudent(Student student){
        studentService.addStudent(student);
        return "loginStudent";
    }
  /*  //更改状态码为2
    @RequestMapping("/acceptStudent")
    public String acceptStudent(int rid){
        Register register=registerService.queryRegisterById(rid);
        register.setState(2);
        registerService.updateRegister(register);
        return "redirect:/student/toStudentRegisted?sno="+register.getSno();
    }*/
}
