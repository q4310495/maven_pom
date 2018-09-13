package com.qf.oa.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.pid
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.dname
     *
     * @mbggenerated
     */
    private String dname;

    private  Department parent;

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.dinfo
     *
     * @mbggenerated
     */
    private String dinfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.createtime
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_department.orderfield
     *
     * @mbggenerated
     */
    private Integer orderfield;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_department
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_department.id
     *
     * @return the value of t_department.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_department.id
     *
     * @param id the value for t_department.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_department.pid
     *
     * @return the value of t_department.pid
     *
     * @mbggenerated
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_department.pid
     *
     * @param pid the value for t_department.pid
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_department.dname
     *
     * @return the value of t_department.dname
     *
     * @mbggenerated
     */
    public String getDname() {
        return dname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_department.dname
     *
     * @param dname the value for t_department.dname
     *
     * @mbggenerated
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_department.dinfo
     *
     * @return the value of t_department.dinfo
     *
     * @mbggenerated
     */
    public String getDinfo() {
        return dinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_department.dinfo
     *
     * @param dinfo the value for t_department.dinfo
     *
     * @mbggenerated
     */
    public void setDinfo(String dinfo) {
        this.dinfo = dinfo == null ? null : dinfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_department.createtime
     *
     * @return the value of t_department.createtime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_department.createtime
     *
     * @param createtime the value for t_department.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_department.orderfield
     *
     * @return the value of t_department.orderfield
     *
     * @mbggenerated
     */
    public Integer getOrderfield() {
        return orderfield;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_department.orderfield
     *
     * @param orderfield the value for t_department.orderfield
     *
     * @mbggenerated
     */
    public void setOrderfield(Integer orderfield) {
        this.orderfield = orderfield;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Department other = (Department) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getDinfo() == null ? other.getDinfo() == null : this.getDinfo().equals(other.getDinfo()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getOrderfield() == null ? other.getOrderfield() == null : this.getOrderfield().equals(other.getOrderfield()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getDinfo() == null) ? 0 : getDinfo().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getOrderfield() == null) ? 0 : getOrderfield().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", dname='" + dname + '\'' +
                ", parent=" + parent +
                ", dinfo='" + dinfo + '\'' +
                ", createtime=" + createtime +
                ", orderfield=" + orderfield +
                '}';
    }
}