package com.wzx.Service;

import com.wzx.Dao.AdminMapper;
import com.wzx.Pojo.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService{
    //service调dao层：组合Dao
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    public int deleteAdminByName(String name) {
        return adminMapper.deleteAdminByName(name);
    }

    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    public Admin queryAdminByName(String name) {
        return adminMapper.queryAdminByName(name);
    }

    public List<Admin> queryAllAdmin() {
        return adminMapper.queryAllAdmin();
    }
}
