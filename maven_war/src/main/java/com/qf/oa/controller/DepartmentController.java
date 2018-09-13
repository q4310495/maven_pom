package com.qf.oa.controller;

import com.qf.oa.entity.Department;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IDepartmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( value = "/dep")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping(value = "/queryAll")
    public String queryAll(Model model, Page page){
        List<Department> departments = departmentService.queryALl();
        model.addAttribute("deps",departments);
        return "deptlist";
    }

    @RequestMapping("/queryAllAjax")
    @ResponseBody
    public List<Department> queryAllAjax(){
        List<Department> deps = departmentService.queryAllAjax();
        System.out.println(deps);
        return deps;
    }

    @RequiresPermissions("/dep/insert")
    @RequestMapping("/insertDep")
    public String insertDep(Department department){
        departmentService.insertDep(department);
        return "redirect:/dep/queryAll";
    }
    @RequestMapping("/delete/{id}")
    public  String delete(@PathVariable("id") Integer id){
        System.out.println(id);
        int ou = departmentService.delete(id);
        System.out.println(ou);
        return "redirect:/dep/queryAll";
    }
}
