package com.qf.oa.dao;

import com.qf.oa.entity.DepCount;
import com.qf.oa.entity.Employee;
import com.qf.oa.entity.Sex;

import java.util.List;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Employee record);

    List<Employee> queryAll();

    Employee queryEmpByEmail(String email);

    List<Employee> queryAllNoMyself(Integer id);

    Sex cotBySex();

    List<DepCount> cotByDep();

    List<Employee> queryByKeyWord(String keyword);
}