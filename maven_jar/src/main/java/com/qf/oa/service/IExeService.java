package com.qf.oa.service;


import com.qf.oa.entity.EmployeeDomain;

import java.util.List;


public interface IExeService {
    List<EmployeeDomain> getAllForExcel();

    Integer addEmps(List<EmployeeDomain> employeeDomains);
}
