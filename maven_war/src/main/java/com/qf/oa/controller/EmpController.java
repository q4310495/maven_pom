package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IEmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    @RequestMapping("/emplist")
    public String queryAll(Model model, Page page){
        List<Employee> emps = empService.queryAll();
        System.out.println(emps);
        model.addAttribute("emps",emps);
        return "emplist";
    }

    @RequiresPermissions("/emp/insert")
    @RequestMapping("insert")
    public  String insertEmp(Employee employee){
        System.out.println(employee);
            empService.insertEmp(employee);

        return "redirect:/emp/emplist";
    }


    @RequestMapping("/queryEmpById")
    @ResponseBody
    public Employee queryEmpById(Integer eid){
       return empService.queryEmpById(eid);
    }

    @RequestMapping("/queryAllNoMyself")
    @ResponseBody
    public List<Employee> queryAllNoMyself(){
      Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();

        return  empService.queryAllNoMyself(employee.getId());
    }
    @RequestMapping("/querybykeyword")
    @ResponseBody
    public List<String> querybykeyword(String keyword){
        List<Employee> employees = empService.queryByKeyWord(keyword);

        List<String> array = new ArrayList<>();
        for (Employee employee : employees) {
            array.add(employee.getName() + "(" + employee.getEmail() + ")");
        }
        return array;
    }

}
