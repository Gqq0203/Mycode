package com.wzx.Dao;

import com.wzx.Pojo.Register;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;
@Resource
public interface ThirdRegisterMapper {
    //增加
    public int addRegister(Register register);
    //删除
    public int  deleteRegisterById(@Param("rid") int id);
    //修改
    public int updateRegister(Register register);
    //查询
    public Register queryRegisterById(@Param("rid") int id);
    public List<Register> queryRegister();
    //根据学号查询
    public List<Register> queryRegisterBySno(@Param("StudentNo") String sno);
    //根据教师编号查询
    public List<Register> queryRegisterByTno(@Param("TeacherNo") String tno);
}
