package org.example.controller;

import org.example.pojo.Category;
import org.example.pojo.Result;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Category")
@Validated
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category){
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list(){
        List<Category> cs=categoryService.list();
        return Result.success(cs);
    }
    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
        Category c=categoryService.findById(id);
        return Result.success(c);
    }
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category){
        category.setUpdateTime(LocalDateTime.now());
        categoryService.update(category);
        return Result.success();

    }
    @DeleteMapping
    public Result delete(@NotNull Integer id){
        categoryService.delete(id);
        return Result.success();

    }
}
