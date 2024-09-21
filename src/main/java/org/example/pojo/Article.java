package org.example.pojo;

import lombok.Data;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String coverImg;
    private String pubDate;//公布时间
    private String state;//发布状态
    private Integer idDelete;//是否被删除
    private Integer cateId;//文章分类id
    private Integer authorId;

}
