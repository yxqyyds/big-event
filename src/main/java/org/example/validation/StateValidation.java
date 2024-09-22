package org.example.validation;

import org.example.anno.State;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {

    /**
     *
     * @param s  将来要校验的数据
     * @param constraintValidatorContext
     * @return  如果返回false校验不通过，true校验通过
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null){
            return false;
        }
        if (s.equals("已发布")||s.equals("草稿")){
            return true;
        }

        return false;
    }
}
