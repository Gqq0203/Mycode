package com.wzx.controller;
import com.wzx.Pojo.Register;
import com.wzx.Pojo.Teacher;
import com.wzx.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 处理预约老师
*
* */
@Controller
@RequestMapping("/first")
public class FirstController {
    @Autowired
    @Qualifier("SecondRegisterServiceImpl")
    private SecondRegisterService  secondRegisterService;

    @Autowired
    @Qualifier("FirstRegisterServiceImpl")
    private FirstRegisterService firstRegisterService;
    @Autowired
    @Qualifier("ThirdRegisterServiceImpl")
    private ThirdRegisterService thirdRegisterService;
    @Autowired
    @Qualifier("RegisterServiceImpl")
    private RegisterService registerService;
    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;
    @Autowired
    @Qualifier("RecordServiceImpl")
    private RecordService recordService;
    @RequestMapping("toFirst")
    public String toFirst(){
        return "firstStudent";
    }

  /*  @RequestMapping("addAllRegister")
    public String addAllRegister(String tno1, String tno2, String tno3, String sno, HttpSession session){
        //若学生状态码为1则已填志愿
        if (studentService.queryById(sno).getState()==1){
            session.setAttribute("msg","请勿重复填报志愿");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }else if (tno1.equals(tno2) || tno1.equals(tno3) || tno2.equals(tno3)){
            session.setAttribute("msg","请勿重复选择教师");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }
        int state1=teacherService.selectTeacherById(tno1).getState();
        int num1=registerService.queryRegisterByTno(tno1).size();
        int state2=teacherService.selectTeacherById(tno2).getState();
        int num2=registerService.queryRegisterByTno(tno2).size();
        int state3=teacherService.selectTeacherById(tno3).getState();
        int num3=registerService.queryRegisterByTno(tno3).size();
        if (state1<=num1){
            session.setAttribute("msg","所选第一志愿教师已上限");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }else if (state2<=num2){
            session.setAttribute("msg","所选第二志愿教师已上限");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }else if (state3<=num3){
            session.setAttribute("msg","所选第三志愿教师已上限");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }
        Register register1=new Register();
        Register register2=new Register();
        Register register3=new Register();
        register1.setSno(sno);
        register1.setTno(tno1);
        register1.setAble(1);
        register1.setState(0);
        firstRegisterService.addRegister(register1);
        register2.setSno(sno);
        register2.setTno(tno2);
        register2.setAble(2);
        register2.setState(0);
        secondRegisterService.addRegister(register2);
        register3.setSno(sno);
        register3.setTno(tno3);
        register3.setAble(3);
        register3.setState(0);
        thirdRegisterService.addRegister(register3);
        Student student=studentService.queryById(sno);
        student.setState(1);
        studentService.updateStudent(student);

        return "redirect:/student/toStudentRegisted?sno="+sno;
    }*/
  @RequestMapping("addAllRegister")
  public String addAllRegister(String tno,String time,String sno, HttpSession session) throws ParseException {

      System.out.println("---成功进入预约方法--");
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date stime = dateFormat.parse(time.replace("T"," "));*/
      System.out.println("tno:"+tno);
      System.out.println("time:"+time);
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Date date=format.parse(time.replace("T"," "));
      System.out.println("处理后time:"+date);
      System.out.println("学生："+sno);
      /*******************************************/
      int Num=studentService.queryById(sno).getNum();
      int state=studentService.queryById(sno).getState();
      Teacher t1;
      Teacher t2;
      t1=firstRegisterService.queryRegisterBySno_Teacher(sno);
      System.out.println(t1);
      t2=secondRegisterService.queryRegisterBySno_Teacher(sno);
      System.out.println(t2);
      //String tno2=secondRegisterService.queryRegisterBySno_Teacher(sno).getTno();

     // System.out.println("tno2:"+tno2);
      //若学生状态码为1则已填志愿
      if (Num>=3){
          session.setAttribute("msg","超出最大预约数！！");
          return "redirect:/student/toStudentRegisted?sno="+sno;
      }else if (state==1){
          session.setAttribute("msg","你已预约到老师，若已完成请联系管理员");
          return "redirect:/student/toStudentRegisted?sno="+sno;
      }else {
          switch (Num){
              case 1:if (tno.equals(t1.getTno()))
                        {session.setAttribute("msg","请勿重复选择教师");
                  return "redirect:/student/toStudentRegisted?sno="+sno;}break;
              case 2:if (tno.equals(t1.getTno())||tno.equals(t2.getTno()))
              {session.setAttribute("msg","请勿重复选择教师");
                  return "redirect:/student/toStudentRegisted?sno="+sno;}break;
          }
      }
      int state1=teacherService.selectTeacherById(tno).getState();
      int num1=registerService.queryRegisterByTno(tno).size();

      if (state1<=num1){
          session.setAttribute("msg","所选教师已预约满额");
          return "redirect:/student/toStudentRegisted?sno="+sno;
      }
      Register register1=new Register();
      Register register2=new Register();
      Register register3=new Register();
      Num++;
      switch (Num){
          case 1: register1.setSno(sno);
              register1.setTno(tno);
              register1.setAble(1);
              register1.setState(0);
              register1.setTime(date);
              firstRegisterService.addRegister(register1);break;
          case 2: register2.setSno(sno);
              register2.setTno(tno);
              register2.setAble(2);
              register2.setState(0);
              register2.setTime(date);
              secondRegisterService.addRegister(register2);break;
          case 3: register3.setSno(sno);
              register3.setTno(tno);
              register3.setAble(3);
              register3.setState(0);
              register3.setTime(date);
              thirdRegisterService.addRegister(register3);break;
      }
      /*register1.setSno(sno);
      register1.setTno(tno1);
      register1.setAble(1);
      register1.setState(0);
      firstRegisterService.addRegister(register1);
      register2.setSno(sno);
      register2.setTno(tno2);
      register2.setAble(2);
      register2.setState(0);
      secondRegisterService.addRegister(register2);
      register3.setSno(sno);
      register3.setTno(tno3);
      register3.setAble(3);
      register3.setState(0);
      thirdRegisterService.addRegister(register3);*/
      Student student=studentService.queryById(sno);
      student.setNum(Num);//更改学生预约的次数
      studentService.updateStudent(student);

      return "redirect:/student/toStudentRegisted?sno="+sno;
  }


    @RequestMapping("appointment")//预约功能
    public String appointment(String tno,String time,String sno,HttpSession session)throws ParseException {
        System.out.println("---成功进入预约方法--");
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date stime = dateFormat.parse(time.replace("T"," "));*/
        System.out.println("tno:"+tno);
        System.out.println("time:"+time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=format.parse(time.replace("T"," "));
        System.out.println("处理后time:"+date);
        System.out.println("学生："+sno);


/**************************************************************************************************/
//若学生状态码为1则已预约
        if (studentService.queryById(sno).getState()==1){
            session.setAttribute("msg","已预约教师，请勿重复操作！！");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }
        int state1=teacherService.selectTeacherById(tno).getState();
        int num1=registerService.queryRegisterByTno(tno).size();

        if (state1<=num1){
            session.setAttribute("msg","所选教师已上限");
            return "redirect:/student/toStudentRegisted?sno="+sno;
        }
        Record record1 = new Record();
        //给record1赋值
        record1.setSno(sno);
        record1.setTno(tno);
        record1.setState(1);
        record1.setTime(date);
        recordService.addRecord(record1);//通过XML写入数据库
        //更新学生状态码
        Student student=studentService.queryById(sno);
        student.setState(1);
        studentService.updateStudent(student);
        //更新老师状态码
        Teacher teacher = teacherService.selectTeacherById(tno);
        teacher.setState(1);
        teacherService.updateTeacher(teacher);
        return "studentView";
    }

}
