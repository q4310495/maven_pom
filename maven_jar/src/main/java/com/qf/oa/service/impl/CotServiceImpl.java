package com.qf.oa.service.impl;

import com.qf.oa.dao.EmployeeMapper;
import com.qf.oa.entity.DepCount;
import com.qf.oa.entity.Sex;
import com.qf.oa.service.ICotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotServiceImpl implements ICotService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Sex cotBySex() {
        return employeeMapper.cotBySex();
    }

    public List<DepCount> cotByDep() {
        return employeeMapper.cotByDep();
    }
}
