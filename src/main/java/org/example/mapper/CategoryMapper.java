package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Category;

@Mapper
public interface CategoryMapper {
    @Insert("insert into en_article_cate(name,alias,create_time,update_time,create_user)"+
    "values(#{name},#{alias},#{createTime},#{updateTime},#{createUser})")
    void add(Category category);
}
