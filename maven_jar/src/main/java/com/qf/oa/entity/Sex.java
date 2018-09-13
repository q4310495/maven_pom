package com.qf.oa.entity;

public class Sex {
    private  Integer man;
    private  Integer woman;

    @Override
    public String toString() {
        return "Sex{" +
                "man=" + man +
                ", woman=" + woman +
                '}';
    }

    public Integer getMan() {
        return man;
    }

    public void setMan(Integer man) {
        this.man = man;
    }

    public Integer getWoman() {
        return woman;
    }

    public void setWoman(Integer woman) {
        this.woman = woman;
    }
}
