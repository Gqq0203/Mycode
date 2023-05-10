package com.wzx.Service;

import com.wzx.Pojo.Register;
import com.wzx.Pojo.Teacher;

import java.util.List;

public interface SecondRegisterService {
    //增加
    public int addRegister(Register register);
    //删除
    public int  deleteRegisterById(int id);
    //修改
    public int updateRegister(Register register);
    //查询
    public Register queryRegisterById(int id);
    public List<Register> queryRegister();
    //根据学号查询
    public List<Register> queryRegisterBySno(String sno);
    //根据学号查询返回教师
    public Teacher queryRegisterBySno_Teacher(String sno);
    //根据教师编号查询
    public List<Register> queryRegisterByTno(String tno);
}
