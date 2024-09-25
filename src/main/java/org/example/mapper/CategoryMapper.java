package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into en_article_cate(name,alias,create_time,update_time,create_user)"+
    "values(#{name},#{alias},#{createTime},#{updateTime},#{createUser})")
    void add(Category category);

    @Select("select * from en_article_cate where create_user=#{userId}")
    List<Category> list(Integer userId);

    @Select("select * from en_article_cate where id=#{id}")
    Category findById(Integer id);

    @Update("update en_article_cate set name=#{name},alias=#{alias},update_time=#{updateTime} where id={id}")
    void update(Category category);

    @Delete("delete from en_article_cate where id=#{id}")
    void delete(Integer id);
}
