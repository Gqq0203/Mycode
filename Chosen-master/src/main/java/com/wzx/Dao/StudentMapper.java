package com.wzx.Dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    //增加
    public int addStudent(Student student);
    //删除
    public int deleteStudentById(@Param("sno") String sno);
    //修改
    public int updateStudent(Student student);
    //查询
    public Student queryById(@Param("studentNo")String sno);

    public List<Student> queryAllStudent();
}
