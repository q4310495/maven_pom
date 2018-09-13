package com.qf.oa.service.impl;

import com.qf.oa.dao.ExeMapper;
import com.qf.oa.entity.EmployeeDomain;
import com.qf.oa.service.IExeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExeServiceImpl implements IExeService {
    @Autowired
    private ExeMapper exeMapper;

    public List<EmployeeDomain> getAllForExcel() {
        return exeMapper.getAllForExcel();
    }

    public Integer addEmps(List<EmployeeDomain> employeeDomains) {
        return exeMapper.addEmps(employeeDomains);
    }
}
