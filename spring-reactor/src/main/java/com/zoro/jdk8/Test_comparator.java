package com.zoro.jdk8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created on 2018/8/3.
 *
 * @author dubber
 */
public class Test_comparator {
    public static void main(String[] args) {

        Integer[] irr = new Integer[]{3,1,77,2,108};
        Comparator<Integer> comparator = Integer::compare;

        Arrays.sort(irr,comparator.reversed());
        System.out.println(Arrays.toString(irr));

    }
}
