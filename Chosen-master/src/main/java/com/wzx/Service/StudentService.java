package com.wzx.Service;

import java.util.List;

public interface StudentService {
    //增加
    public int addStudent(Student student);
    //删除
    public int deleteStudentById(String sno);
    //修改
    public int updateStudent(Student student);
    //查询
    public Student queryById(String sno);

    public List<Student> queryAllStudent();
}
