package com.gm.bean;

/**
 * 2020/3/3 14:43
 * 实体类模型，映射数据字段的模型/对象
 */
public class Role {

    private int rid;
    private String rname;
    private String rdesc;
    private String raddres;
    private String rphone;

    public Role() {
    }

    public Role(int rid, String rname, String rdesc, String raddres, String rphone) {
        this.rid = rid;
        this.rname = rname;
        this.rdesc = rdesc;
        this.raddres = raddres;
        this.rphone = rphone;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public String getRaddres() {
        return raddres;
    }

    public void setRaddres(String raddres) {
        this.raddres = raddres;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                ", raddres='" + raddres + '\'' +
                ", rphone='" + rphone + '\'' +
                '}';
    }
}
