package com.zoro.jdk8;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/3
 */
public class Test implements Vehicle {


    @Override
    public void test() {

    }

    @Override
    public void print() {
        System.out.println("");
    }

    public static void main(String[] args) {
        new Test().print();
    }
}
