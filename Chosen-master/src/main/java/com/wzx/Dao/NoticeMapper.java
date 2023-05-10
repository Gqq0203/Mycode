package com.wzx.Dao;

import com.wzx.Pojo.Notice;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface NoticeMapper {
    //增加
    public int addNotice(Notice notice);
    //删除
    public int deleteNoticeById(@Param("nid") int id);
    //修改
    public int updateNotice(Notice notice);
    //查询
    public Notice queryNoticeById(@Param("nid") int id);
    public List<Notice> queryAllNotice();
}
