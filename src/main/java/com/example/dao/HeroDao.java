package com.example.dao;

import com.example.domain.Hero;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * Created by wangjinzhao on 2017/2/6.
 */
@Component
public class HeroDao {
    private final SqlSession sqlSession;

    public HeroDao(SqlSession sqlSession)
    {
        this.sqlSession=sqlSession;
    }

    public Hero selectByName(String name)
    {
        return sqlSession.selectOne("selectByName",name);
    }
}
