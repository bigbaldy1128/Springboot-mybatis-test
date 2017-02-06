package com.example;

import com.example.dao.HeroDao;
import com.example.domain.Hero;
import com.example.domain.HeroMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(MybatisDemoApplication.class);

    @Autowired
    HeroMapper heroMapper;

    @Autowired
    HeroDao heroDao;

    @Test
    public void selectByName() {
        Assert.assertEquals(heroMapper.selectByName("Bombasto").getId(), 3);
    }

    @Test
    public void selectById() {
        Assert.assertEquals(heroMapper.selectById(3).getName(), "Bombasto");
    }

    @Test
    public void selectByNameFromDao() {
        Assert.assertEquals(heroDao.selectByName("Bombasto").getId(), 3);
    }

    @Test
    public void insertHero() {
        Hero hero = new Hero();
        hero.setName("wjz");
        heroMapper.insertHero(hero);
        logger.info("插入的Id:" + hero.getId());
    }

    @Test
    public void selectByNameWithTableName() {
        Assert.assertEquals(heroMapper.selectByNameWithTableName("Bombasto", "hero").getId(), 3);
    }

    @Test
    public void insertBatch() {
        List<Hero> heroes = new ArrayList<>();
        Hero hero1 = new Hero();
        hero1.setName("wjz1");
        Hero hero2 = new Hero();
        hero2.setName("wjz2");
        heroes.add(hero1);
        heroes.add(hero2);
        heroMapper.insertBatch(heroes);
    }

    @Test
    public void insertBatchByAnnotation() {
        List<Hero> heroes = new ArrayList<>();
        Hero hero1 = new Hero();
        hero1.setName("wjz1");
        Hero hero2 = new Hero();
        hero2.setName("wjz2");
        heroes.add(hero1);
        heroes.add(hero2);
        heroMapper.insertBatchByAnnotation(heroes);
    }
}
