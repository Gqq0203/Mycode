package com.wzx.Service;

import com.wzx.Pojo.Notice;
import java.util.List;

public interface NoticeService {
    //增加
    public int addNotice(Notice notice);
    //删除
    public int deleteNoticeById(int id);
    //修改
    public int updateNotice(Notice notice);
    //查询
    public Notice queryNoticeById(int id);
    public List<Notice> queryAllNotice();
}
