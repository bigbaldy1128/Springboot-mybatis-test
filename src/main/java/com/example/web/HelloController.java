package com.example.web;

import com.example.Service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangjinzhao on 2017/5/23.
 */
@RestController
public class HelloController {

    @Autowired
    HeroService heroService;

    @GetMapping("/hello")
    public String hello()
    {
        return heroService.findHero("Mr. Nice");
    }
}
