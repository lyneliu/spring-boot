package com.lyne.controller;


import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimaps;
import com.lyne.bo.PrdBean;
import com.lyne.service.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by nn_liu on 2017/5/17.
 */

@RestController
public class HomeController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/home")
    public String index(ModelMap map){

        map.addAttribute("name","luffy");
        map.addAttribute("desc","sea world");
        return "json";
    }

    @RequestMapping("/validate")
    public String validate(ModelMap map){
        List<PrdBean> prdBeans = new ArrayList<>();
        prdBeans = new ArrayList<>();
        PrdBean prdBean01 = new PrdBean();
        prdBean01.setAddr("shanghai");
        PrdBean prdBean02 = new PrdBean();
        prdBean02.setAddr("shanghai");
        prdBeans.add(prdBean01);
        prdBeans.add(prdBean02);

        demoService.guavaMapDemo(prdBeans);

        return "success";
    }

    @RequestMapping("/validate-test")
    public String validatePrd(ModelMap map){

        PrdBean prdBean01 = new PrdBean();
        prdBean01.setAddr("shanghai");

        demoService.handle(prdBean01);

        return "success";
    }

}
