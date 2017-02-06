package com.example.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wangjinzhao on 2017/2/6.
 */
@Mapper
public interface HeroMapper {
    Hero selectByName(@Param("name") String name);

    Hero selectByNameWithTableName(@Param("name") String name,@Param("tableName") String tableName);

    @Select("select * from hero where id=#{id}")
    Hero selectById(@Param("id") int id);

    int insertHero(@Param("p_hero") Hero hero);

    int insertBatch(@Param("heroes") List<Hero> heroes);

    @Insert({
            "<script>",
            "insert into hero(id,name)",
            "values",
            "<foreach collection='heroes' item='hero' separator=','>",
            "(null,#{hero.name})",
            "</foreach>",
            "</script>"
    })
    int insertBatchByAnnotation(@Param("heroes") List<Hero> heroes);
}
