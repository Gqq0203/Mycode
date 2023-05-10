package com.wzx.Dao;

import com.wzx.Pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //增加
    public int addTeacher(Teacher teacher);
    //删除
    public int delectTeacherById(@Param("teacherNo") String tno);
    //修改
    public int updateTeacher(Teacher teacher);
    //查询
    public Teacher selectTeacherById(@Param("teacherNo")String tno);
    public List<Teacher> selectTeacherByState();//查询状态为0（可选教师）的数据
    public List<Teacher> selectAllTeacher();
}
