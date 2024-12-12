package org.example.TestStream;

import java.util.List;

/**
 * 映射测试类
 */
public class TestMap {
    //水果类
    record Fruit(String cname, String name, String category, String color) {
    }

    public static void main(String[] args) {
        List<TestFiller.Fruit> fruits = List.of(
                new TestFiller.Fruit("草莓", "Strawberry", "浆果", "红色"),
                new TestFiller.Fruit("桑葚", "Mulberry", "浆果", "紫色"),
                new TestFiller.Fruit("杨梅", "Waxberry", "浆果", "红色"),
                new TestFiller.Fruit("核桃", "Walnut", "坚果", "棕色"),
                new TestFiller.Fruit("草莓", "Peanut", "坚果", "棕色"),
                new TestFiller.Fruit("蓝莓", "Blueberry", "浆果", "蓝色")
        );
        //水果打成酱
        List<String> list = fruits.stream().map(fruit -> fruit.cname() + "酱").toList();
        System.out.println(list);
    }
}