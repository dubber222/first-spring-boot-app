package com.zoro.springbootvalidate.validation.constraints;

import com.zoro.springbootvalidate.validation.ValidCardNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 通过员工的卡号来校验，需要通过工号的前缀和后缀来判断
 * 前缀必须以"ZORO-"
 * 后缀必须是数字
 * <p>
 * Created on 2018/8/16.
 *
 * @author dubber
 */

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidCardNumberConstraintValidator.class})
public @interface ValidCardNumber {
    String message() default "{zoro.validation.constraints.AssertDiy.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
