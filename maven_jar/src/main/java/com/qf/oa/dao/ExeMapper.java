package com.qf.oa.dao;

import com.qf.oa.entity.EmployeeDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExeMapper {
    List<EmployeeDomain> getAllForExcel();

    Integer addEmps(@Param("employeeDomains") List<EmployeeDomain> employeeDomains);
}
