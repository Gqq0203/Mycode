package com.wzx.Service;

import com.wzx.Dao.NoticeMapper;
import com.wzx.Pojo.Notice;
import java.util.List;

public class NoticeServiceImpl implements NoticeService{
    private NoticeMapper noticeMapper;
    public void setNoticeMapper(NoticeMapper noticeMapper){
        this.noticeMapper=noticeMapper;
    }
    public int addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }

    public int deleteNoticeById(int id) {
        return noticeMapper.deleteNoticeById(id);
    }

    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    public Notice queryNoticeById(int id) {
        return noticeMapper.queryNoticeById(id);
    }

    public List<Notice> queryAllNotice() {
        return noticeMapper.queryAllNotice();
    }
}