package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Integer add(@PathVariable int x, @PathVariable int y) {

        Integer sum = x+y;
        return sum;
    }

    @RequestMapping(path="/subtract/{x}/from/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Integer subtract(@PathVariable int x, @PathVariable int y){
        Integer dif = x-y;
        return dif;
    }

    @RequestMapping(path="/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Double multiply(@PathVariable double x, @PathVariable double y){
        double product = x * y;
        return product;
    }

    @RequestMapping(path="/divide/{x}/by/{y}", method = RequestMethod.GET)
    @ResponseBody
    public double divide(@PathVariable double x, @PathVariable double y){
        Double quotient = x/y;
        return quotient;
    }

}
