package org.example.TestStream;

import java.util.List;
import java.util.function.Predicate;

/**
 * 过滤测试类
 */
public class TestFiller {
    //水果类
    record Fruit(String cname, String name, String category, String color) {
    }

    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
                new Fruit("草莓", "Strawberry", "浆果", "红色"),
                new Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                new Fruit("杨梅", "Waxberry", "浆果", "红色"),
                new Fruit("核桃", "Walnut", "坚果", "棕色"),
                new Fruit("草莓", "Peanut", "坚果", "棕色"),
                new Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
        );
        //找到所有浆果
        List<Fruit> fruits1 = fruits.stream().filter(fruit -> fruit.category.equals("浆果")).toList();
        System.out.println(fruits1);
        System.out.println("------------------------------------------");
        //找到蓝色的浆果
        List<Fruit> fruits2 = fruits.stream().filter(fruit -> fruit.category.equals("浆果") && fruit.color.equals("蓝色")).toList();
        System.out.println(fruits2);
        //.and连接两个条件
        List<Fruit> fruits3 = fruits.stream().filter((((Predicate<Fruit>) f -> f.category.equals("浆果")).and(f -> f.color().equals("蓝色")))).toList();
        System.out.println(fruits3);
        //分开用两个filer连接的关系是与
        List<Fruit> fruits4 = fruits.stream().filter(fruit -> fruit.category.equals("浆果"))
                .filter(fruit -> fruit.color.equals("蓝色")).toList();
        System.out.println(fruits4);
    }
}
