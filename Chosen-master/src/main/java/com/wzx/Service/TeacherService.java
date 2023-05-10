package com.wzx.Service;

import com.wzx.Pojo.Teacher;

import java.util.List;

public interface TeacherService {
    //增加
    public int addTeacher(Teacher teacher);
    //删除
    public int delectTeacherById(String tno);
    //修改
    public int updateTeacher(Teacher teacher);
    //查询
    public Teacher selectTeacherById(String tno);
    public List<Teacher> selectTeacherByState();//查询状态为0（可选教师）的数据
    public List<Teacher> selectAllTeacher();
}
