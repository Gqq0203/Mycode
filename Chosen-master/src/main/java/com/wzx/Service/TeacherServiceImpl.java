package com.wzx.Service;

import com.wzx.Dao.TeacherMapper;
import com.wzx.Pojo.Teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    //service调dao层：组合Dao
    private TeacherMapper teacherMapper;
    public void setTeacherMapper(TeacherMapper teacherMapper){
        this.teacherMapper=teacherMapper;
    }

    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    public int delectTeacherById(String tno) {
        return teacherMapper.delectTeacherById(tno);
    }

    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    public Teacher selectTeacherById(String tno) {
        return teacherMapper.selectTeacherById(tno);
    }
    public List<Teacher> selectTeacherByState(){
        return teacherMapper.selectTeacherByState();
    }//查询状态为0（可选教师）的数据
    public List<Teacher> selectAllTeacher() {
        return teacherMapper.selectAllTeacher();
    }

}
