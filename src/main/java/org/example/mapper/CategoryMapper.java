package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into en_article_cate(name,alias,create_time,update_time,create_user)"+
    "values(#{name},#{alias},#{createTime},#{updateTime},#{createUser})")
    void add(Category category);

    @Select("select * from en_article_cate where create_user=#{userId}")
    List<Category> list(Integer userId);
}
