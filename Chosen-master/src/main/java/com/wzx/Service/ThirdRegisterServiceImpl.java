package com.wzx.Service;

import com.wzx.Dao.ThirdRegisterMapper;
import com.wzx.Pojo.Register;

import java.util.List;

public class ThirdRegisterServiceImpl implements ThirdRegisterService{
    //service调dao层：组合Dao

    private ThirdRegisterMapper thirdRegisterMapper;
    public void setThirdRegisterMapper(ThirdRegisterMapper thirdRegisterMapper){
        this.thirdRegisterMapper=thirdRegisterMapper;
    }

    public int addRegister(Register register) {
        return thirdRegisterMapper.addRegister(register);
    }

    public int deleteRegisterById(int id) {
        return thirdRegisterMapper.deleteRegisterById(id);
    }

    public int updateRegister(Register register) {
        return thirdRegisterMapper.updateRegister(register);
    }

    public Register queryRegisterById(int id) {
        return thirdRegisterMapper.queryRegisterById(id);
    }

    public List<Register> queryRegister() {
        return thirdRegisterMapper.queryRegister();
    }

    public List<Register> queryRegisterBySno(String sno) {
        return thirdRegisterMapper.queryRegisterBySno(sno);
    }

    public List<Register> queryRegisterByTno(String tno) {
        return thirdRegisterMapper.queryRegisterByTno(tno);
    }
}
