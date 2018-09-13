package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import com.qf.oa.utli.TokenUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/im")
public class ImController {

    @RequestMapping("/sendmsg")
    @ResponseBody
    public void sendmsg(Integer toid,String content){
        Employee employee= (Employee) SecurityUtils.getSubject().getPrincipal();

        TokenUtil.sendmsg(employee.getId()+"",content,toid+"");
    }

}
