package com.hnu.scw.controller;

import com.hnu.scw.pojo.Person;
import com.hnu.scw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试springboot的环境搭建(controller控制层)
 */
@Controller
public class MyTest {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/toaddperson")
    public String toAddPersonJsp(){
        return "person_add";
    }
    @RequestMapping(value = "/addperson")
    public String addPersonOption(Person person){
        personService.personAdd(person);
        return "redirect:/list" ;
    }

    @RequestMapping(value = "/list")
    public String jumpJsp(){

        return "person_list";
    }
}
