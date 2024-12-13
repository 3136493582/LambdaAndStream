package org.example.TestStream;

import java.util.stream.Stream;

/**
 * Stream流的排序与去重
 */
public class TestSortedAndDistinct {

    record Hero(String name, int strength) { }

    public static void main(String[] args) {
        Stream<Hero> heroStream = Stream.of(
                new Hero("独孤求败", 100),
                new Hero("令狐冲", 90),
                new Hero("风清扬", 98),
                new Hero("东方不败", 98),
                new Hero("方证", 92),
                new Hero("任我行", 92),
                new Hero("冲虚", 90),
                new Hero("向问天", 88),
                new Hero("不戒", 88)
        );

        //排序方法一：正数升序，负数降序
        //heroStream.sorted((a,b)->a.strength-b.strength).forEach(System.out::println);

        //排序方法二：使用包装类的比较方法
        //heroStream.sorted((a,b)->Integer.compare(a.strength,b.strength)).forEach(System.out::println);

        //排序方法三：使用比较器提取关键词
       // heroStream.sorted(Comparator.comparingInt(h-> h.strength)).forEach(System.out::println);

        //排序方法四：用武力值排序，然后用名字长度排序
       //heroStream.sorted(Comparator.comparingInt(Hero::strength).thenComparingInt(h->h.name.length())).forEach(System.out::println);

        //去重
        heroStream.distinct().forEach(System.out::println);
    }
}
