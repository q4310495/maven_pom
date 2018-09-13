package com.qf.oa.controller;

import com.qf.oa.entity.Resc;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IRescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/resc")
public class RescController {
    @Autowired
    private IRescService rescService;

    @RequestMapping("/resclist")
    public String queryAll(Model model,Page page){
      List<Resc> rescs=rescService.queryAll();
      model.addAttribute("rescs",rescs);
      return "resclist";
    }


    @RequestMapping("/queryRescById")
    @ResponseBody
    public List<Resc> queryAllAjax(Integer rid){
        System.out.println(rid);
        List<Resc> rescs = rescService.queryresc(rid);
        System.out.println(rescs);
        return rescs;
    }

    @RequestMapping("/insert")
    public String insertResc(Resc resc){
        rescService.insertResc(resc);
        return "redirect:/resc/resclist";
    }


    @RequestMapping("/selectresc")
    @ResponseBody
    public Integer selectResc(Integer rid, Integer[] reids){
        int result = rescService.updateRescAndRole(rid, reids);
        return result;
    }

}
