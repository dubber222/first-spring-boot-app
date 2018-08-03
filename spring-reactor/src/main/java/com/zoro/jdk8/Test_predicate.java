package com.zoro.jdk8;

import java.util.function.Predicate;

/**
 * Created on 2018/8/3.
 *
 * @author dubber
 */
public class Test_predicate {

    public static void main(String[] args) {

        // JDK8 函数接口
        Predicate<Integer> predicate = x -> x > 3;
        System.out.println(predicate.test(10));//true
        System.out.println(predicate.negate().test(10));//false
        System.out.println(predicate.or(x -> x < 1).and(x -> x > -1).negate().test(-1));//true

    }
}
