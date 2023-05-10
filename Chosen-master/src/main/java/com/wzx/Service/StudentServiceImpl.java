package com.wzx.Service;

import com.wzx.Dao.StudentMapper;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    //service调dao层：组合Dao
    private StudentMapper studentMapper;
    public void setStudentMapper(StudentMapper studentMapper){
        this.studentMapper=studentMapper;
    }

    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public int deleteStudentById(String sno) {
        return studentMapper.deleteStudentById(sno);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public Student queryById(String sno) {
        return studentMapper.queryById(sno);
    }

    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }
}
