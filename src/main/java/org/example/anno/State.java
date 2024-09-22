package org.example.anno;

import org.example.validation.StateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {StateValidation.class}
)
public @interface State {
    //提供校验失败后的提示信息
    String message() default "state的参数的值只能是已发布或者草稿";
    //指定分组
    Class<?>[] groups() default {};
    //负载  获取到state注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
