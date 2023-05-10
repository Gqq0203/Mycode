package com.wzx.Service;

import com.wzx.Dao.RegisterMapper;
import com.wzx.Pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegisterServiceImpl implements RegisterService{
    //service调dao层：组合Dao

    private RegisterMapper registerMapper;
    public void setRegisterMapper(RegisterMapper registerMapper){
        this.registerMapper=registerMapper;
    }

    public int addRegister(Register register) {
        return registerMapper.addRegister(register);
    }

    public int deleteRegisterById(int id) {
        return registerMapper.deleteRegisterById(id);
    }

    public int updateRegister(Register register) {
        return registerMapper.updateRegister(register);
    }

    public Register queryRegisterById(int id) {
        return registerMapper.queryRegisterById(id);
    }

    public List<Register> queryRegister() {
        return registerMapper.queryRegister();
    }

    public List<Register> queryRegisterBySno(String sno) {
        return registerMapper.queryRegisterBySno(sno);
    }

    public List<Register> queryRegisterByTno(String tno) {
        return registerMapper.queryRegisterByTno(tno);
    }
}
