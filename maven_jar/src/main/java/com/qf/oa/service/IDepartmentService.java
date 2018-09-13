package com.qf.oa.service;

import com.qf.oa.entity.Department;

import java.util.List;


public interface IDepartmentService {
    List<Department> queryALl();

    List<Department> queryAllAjax();

    int insertDep(Department department);

    int delete(Integer id);
}
