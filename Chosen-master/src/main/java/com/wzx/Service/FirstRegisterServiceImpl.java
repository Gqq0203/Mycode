package com.wzx.Service;

import com.wzx.Dao.FirstRegisterMapper;
import com.wzx.Dao.RegisterMapper;
import com.wzx.Pojo.Register;
import com.wzx.Pojo.Teacher;

import java.util.List;

public class FirstRegisterServiceImpl implements FirstRegisterService{
    private FirstRegisterMapper firstRegisterMapper;
    public void setFirstRegisterMapper(FirstRegisterMapper firstRegisterMapper){
        this.firstRegisterMapper=firstRegisterMapper;
    }

    public int addRegister(Register register) {
        return firstRegisterMapper.addRegister(register);
    }

    public int deleteRegisterById(int id) {
        return firstRegisterMapper.deleteRegisterById(id);
    }

    public int updateRegister(Register register) {
        return firstRegisterMapper.updateRegister(register);
    }

    public Register queryRegisterById(int id) {
        return firstRegisterMapper.queryRegisterById(id);
    }

    public List<Register> queryRegister() {
        return firstRegisterMapper.queryRegister();
    }

    public List<Register> queryRegisterBySno(String sno) {
        return firstRegisterMapper.queryRegisterBySno(sno);
    }
    public Teacher queryRegisterBySno_Teacher(String sno){
        return firstRegisterMapper.queryRegisterBySno_Teacher(sno);
    }

    public List<Register> queryRegisterByTno(String tno) {
        return firstRegisterMapper.queryRegisterByTno(tno);
    }
}
