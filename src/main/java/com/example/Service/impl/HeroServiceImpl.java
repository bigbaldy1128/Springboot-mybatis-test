package com.example.Service.impl;

import com.example.Service.HeroService;
import com.example.domain.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjinzhao on 2017/5/23.
 */
@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    HeroMapper heroMapper;

    @Override
    public String findHero(String name) {
        return heroMapper.selectByName(name).getName();
    }
}
