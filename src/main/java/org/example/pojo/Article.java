package org.example.pojo;

import lombok.Data;
import org.example.anno.State;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import java.time.LocalDateTime;

@Data
public class Article {
    @NotNull(groups = update.class)
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    @URL
    private String coverImg;
    @State
    private String state;//发布状态
    @NotNull
    private Integer cateId;//文章分类id
    private Integer authorId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public interface update extends Default{

    }
    public interface add extends Default{

    }

}
