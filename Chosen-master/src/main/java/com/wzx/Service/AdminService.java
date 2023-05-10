package com.wzx.Service;

import com.wzx.Pojo.Admin;

import java.util.List;

public interface AdminService {
    //增加
    public int addAdmin(Admin admin);
    //删除
    public int deleteAdminByName(String name);
    //修改
    public int updateAdmin(Admin admin);
    //查询
    public Admin queryAdminByName(String name);
    public List<Admin> queryAllAdmin();
}
