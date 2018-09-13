package com.qf.oa.controller;

import com.qf.oa.entity.Role;
import com.qf.oa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/rolelist")
    public String queryAll(Model model){
        List<Role> roles=roleService.queryAll();
        model.addAttribute("roles",roles);
        return "rolelist";
    }

    @RequestMapping("/queryRoleById")
    @ResponseBody
    public List<Role> queryRoleById(Integer eid){
        System.out.println("eid："+eid);
           List<Role> roles=roleService.queryRoleById(eid);
         return  roles;
    }

    @RequestMapping("/selectroles")
    public String selectroles(Integer eid,Integer[] rid ){
        roleService.selectroles(eid, rid);
        return "redirect:/emp/queryAll";

    }
    @RequestMapping("/insert")
    public String insertRole(Role role){
        roleService.insertRole(role);
        return "redirect:/role/rolelist";
    }



}
