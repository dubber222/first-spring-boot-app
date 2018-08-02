package com.zoro.jdk8;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/3
 */
public interface Vehicle {


    public void test();


    default void print(){
        System.out.println("我是一辆车!");
    }

    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }
}
