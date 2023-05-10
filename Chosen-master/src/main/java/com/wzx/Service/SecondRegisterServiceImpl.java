package com.wzx.Service;

import com.wzx.Dao.SecondRegisterMapper;
import com.wzx.Dao.ThirdRegisterMapper;
import com.wzx.Pojo.Register;
import com.wzx.Pojo.Teacher;

import java.util.List;

public class SecondRegisterServiceImpl implements SecondRegisterService{
    //service调dao层：组合Dao

    private SecondRegisterMapper secondRegisterMapper;
    public void setSecondRegisterMapper(SecondRegisterMapper secondRegisterMapper){
        this.secondRegisterMapper=secondRegisterMapper;
    }

    public int addRegister(Register register) {
        return secondRegisterMapper.addRegister(register);
    }
    public int deleteRegisterById(int id) {
        return secondRegisterMapper.deleteRegisterById(id);
    }

    public int updateRegister(Register register) {
        return secondRegisterMapper.updateRegister(register);
    }

    public Register queryRegisterById(int id) {
        return secondRegisterMapper.queryRegisterById(id);
    }

    public List<Register> queryRegister() {
        return secondRegisterMapper.queryRegister();
    }

    public List<Register> queryRegisterBySno(String sno) {
        return secondRegisterMapper.queryRegisterBySno(sno);
    }
    public Teacher queryRegisterBySno_Teacher(String sno){
        return secondRegisterMapper.queryRegisterBySno_Teacher(sno);
    }
    public List<Register> queryRegisterByTno(String tno) {
        return secondRegisterMapper.queryRegisterByTno(tno);
    }
}
