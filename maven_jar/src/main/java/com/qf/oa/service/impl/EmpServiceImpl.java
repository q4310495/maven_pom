package com.qf.oa.service.impl;

import com.qf.oa.dao.EmployeeMapper;
import com.qf.oa.entity.Employee;
import com.qf.oa.service.IEmpService;
import com.qf.oa.utli.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService{
   @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> queryAll() {
        return employeeMapper.queryAll();
    }

    public int insertEmp(Employee employee) {
        if(employee.getId()==null||employee.getId().equals("")){
            int result = employeeMapper.insert(employee);
            String token = TokenUtil.getToken(employee);
            employee.setToken(token);
            System.out.println("++++++++:"+employee);
            employeeMapper.updateByPrimaryKey(employee);
            return  result;
        }else {
             return employeeMapper.updateByPrimaryKey(employee);
        }
    }

    public Employee queryEmpById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public Employee queryEmpByEmail(String email) {
        return employeeMapper.queryEmpByEmail(email);
    }

    public List<Employee> queryAllNoMyself(Integer id) {
        return employeeMapper.queryAllNoMyself(id);
    }

    public List<Employee> queryByKeyWord(String keyword) {
        return employeeMapper.queryByKeyWord(keyword);
    }
}
