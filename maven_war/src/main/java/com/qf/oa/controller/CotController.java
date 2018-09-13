package com.qf.oa.controller;

import com.qf.oa.entity.DepCount;
import com.qf.oa.entity.Sex;
import com.qf.oa.service.ICotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cot")
public class CotController {
    @Autowired
    private ICotService cotService;

    @RequestMapping("/cotBySex")
    public String cotBySex(Model model){
        Sex sex = cotService.cotBySex();
        model.addAttribute("sex",sex);
        return "cotSexlist";
    }

    @RequestMapping("/cotByDep")
  public String cotByDep(Model model){
        List<DepCount> depCounts = cotService.cotByDep();
        System.out.println("++++++:"+depCounts);
        model.addAttribute("depCounts",depCounts);
        return "cotDeplist";
    }
}
