package com.zoro.springbootvalidate.validation;

import com.zoro.springbootvalidate.validation.constraints.ValidCardNumber;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created on 2018/8/16.
 *
 * @author dubber
 */
public class ValidCardNumberConstraintValidator implements ConstraintValidator<ValidCardNumber, String> {
    @Override
    public void initialize(ValidCardNumber constraintAnnotation) {

    }

    /**
     * 需求：通过员工的卡号来校验，需要通过工号的前缀和后缀来判断
     * <p>
     * 前缀必须以"ZORO-"
     * <p>
     * 后缀必须是数字
     * <p>
     * 需要通过 Bean Validator 检验
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String[] parts = StringUtils.split(value, "-");
        // 为什么不用 String#split 方法，原因在于该方法使用了正则表达式
        // 其次是 NPE 保护不够
        // 如果在依赖中，没有 StringUtils.delimitedListToStringArray API 的话呢，可以使用
        // Apache commons-lang StringUtils
        // JDK 里面 StringTokenizer（不足类似于枚举 Enumeration API）

        if (ArrayUtils.getLength(parts) != 2) {
            return false;
        }

        String prefix = parts[0];
        String suffix = parts[1];

        boolean isValidPrefix = StringUtils.equals(prefix,"ZORO");
        boolean isValidNumeric = StringUtils.isNumeric(suffix);

        return isValidPrefix && isValidNumeric;
    }
}
