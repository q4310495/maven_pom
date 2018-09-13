package com.qf.oa.controller;

import com.qf.oa.entity.EmployeeDomain;
import com.qf.oa.export.ExportExcel;
import com.qf.oa.export.InExcel;
import com.qf.oa.service.IExeService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/exe")
public class ExeController {

    @Autowired
    private IExeService exeService;

    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeDomain> empList = exeService.getAllForExcel();
        System.out.println(empList);
        ExportExcel<EmployeeDomain> ee= new ExportExcel<EmployeeDomain>();
        String[] headers = { "序号", "邮箱","密码","姓名","电话","性别","生日", "描述", "入职时间"};
        String fileName = "员工信息表";
        ee.exportExcel(headers,empList,fileName,response);
    }

    @RequestMapping("Input")
    public String Input() throws IOException, InvalidFormatException {
        InExcel inExcel=new InExcel();
        List<EmployeeDomain> employeeDomains = inExcel.loadScoreInfo();
         exeService.addEmps(employeeDomains);
      return "redirect:/emp/emplist";

    }
}
