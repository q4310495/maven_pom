package com.qf.oa.entity;

public class DepCount {
   private  String dname;
   private  Integer count;

    @Override
    public String toString() {
        return "DepCount{" +
                "dname='" + dname + '\'' +
                ", count=" + count +
                '}';
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
