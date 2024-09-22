package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.ArticleMapper;
import org.example.pojo.Article;
import org.example.pojo.PageBean;
import org.example.service.ArticleService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        article.setAuthorId(id);
        articleMapper.add(article);

    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer cateId, String state) {
        //创建PageBean对象
        PageBean<Article> pb=new PageBean<>();
        //开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //调用Mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer authorId =(Integer) map.get("id");
        List<Article> as=articleMapper.list(authorId,cateId,state);
        Page<Article> p=(Page<Article>) as;
        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
