package com.wzx.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Teacher {
    private String tname;
    private String password;
    private String tno;
    private Integer state;

    public Teacher(String tname, String password, String tno, Integer state) {
        this.tname = tname;
        this.password = password;
        this.tno = tno;
        this.state = state;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
