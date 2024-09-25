package org.example.controller;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Article;
import org.example.pojo.PageBean;
import org.example.pojo.Result;

import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated(Article.add.class) Article article){
        articleService.add(article);
        return Result.success();

    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer cateId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pg=articleService.list(pageNum,pageSize,cateId,state);
        return Result.success(pg);
    }
    @PutMapping
    public Result update(@RequestBody @Validated(Article.update.class) Article article){
        articleService.update(article);
        return Result.success();

    }

    @DeleteMapping
    public Result delete(@NotNull Integer id){
        articleService.delete(id);
        return Result.success();

    }


}
