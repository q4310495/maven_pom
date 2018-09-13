package com.qf.oa.service;

import com.qf.oa.entity.Employee;

import java.util.List;

public interface IEmpService {
    List<Employee> queryAll();

    int insertEmp(Employee employee);

    Employee queryEmpById(Integer id);

    Employee queryEmpByEmail(String email);

    List<Employee> queryAllNoMyself(Integer id);


    List<Employee> queryByKeyWord(String keyword);
}
