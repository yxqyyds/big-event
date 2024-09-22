package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into en_articles(title, content, cover_img, state, cate_id, author_id, create_time, update_time) " +
            "values(#{title},#{content},#{coverImg},#{state},#{cateId},#{authorId},#{createTime},#{updateTime})")
    void add(Article article);

    List<Article> list(Integer authorId, Integer cateId, String state);
}
