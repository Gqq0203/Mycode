package com.wzx.Dao;

import com.wzx.Pojo.Admin;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;
@Resource
public interface AdminMapper {
    //增加
    public int addAdmin(Admin admin);
    //删除
    public int deleteAdminByName(@Param("adminName") String name);
    //修改
    public int updateAdmin(Admin admin);
    //查询
    public Admin queryAdminByName(@Param("adminName") String name);
    public List<Admin> queryAllAdmin();
}
