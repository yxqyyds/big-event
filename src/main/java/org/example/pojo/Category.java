package org.example.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String alias;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
