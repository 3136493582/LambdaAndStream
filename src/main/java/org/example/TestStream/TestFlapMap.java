package org.example.TestStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * h2>扁平化映射  降维<</h2>
 * <p>构建stream的三种方法</p>
 * <p>1、collection的子类可以直接 集合变量名.stream构建</p>
 * <p>2、数组构建：Array.Stream(数组变量)</p>
 * <p>3、对象构建：Stream.of(对象)</p>
 */
public class TestFlapMap {
    //水果类
    record Fruit(String cname, String name, String category, String color) {
    }

    public static void main(String[] args) {
        Stream.of(List.of(
                        new Fruit("草莓", "Strawberry", "浆果", "红色"),
                        new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                        new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                        new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
                ),
                List.of(
                        new Fruit("核桃", "Walnut", "坚果", "棕色"),
                        new Fruit("草莓", "Peanut", "坚果", "棕色")
                )).flatMap(List::stream).forEach(System.out::println);

        Integer[][] arr={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Arrays.stream(arr).flatMap(array->Arrays.stream(array)).forEach(System.out::println);
//        等价于下
        Arrays.stream(arr).flatMap(Arrays::stream).forEach(System.out::println);

    }
}
