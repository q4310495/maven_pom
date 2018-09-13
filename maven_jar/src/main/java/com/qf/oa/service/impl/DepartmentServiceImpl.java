package com.qf.oa.service.impl;

import com.qf.oa.dao.DepartmentMapper;
import com.qf.oa.entity.Department;
import com.qf.oa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> queryALl() {
        return departmentMapper.queryAll();
    }

    public List<Department> queryAllAjax() {
        return departmentMapper.queryAll();
    }

    public int insertDep(Department department) {
        return departmentMapper.insert(department);
    }

    public int delete(Integer id) {
        return  departmentMapper.deleteById(id);
    }
}
