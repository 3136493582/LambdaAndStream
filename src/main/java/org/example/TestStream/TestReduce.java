package org.example.TestStream;

import java.util.stream.Stream;

/**
 * <p>化简：两两合并，只剩一个</p>
 * <p>适合：最大值、最小值、求和、求个数..</p>
 * <p>.reduce（(p，x）->r)     p 上次合并结果，x当前值，本次合并结果</p>
 *<p>.reduce（init，（p，x）->r)</p>
 * <p>.reduce(init，（p，x）->r，（r1，r2）->r)</p>
 */

public class TestReduce {
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

        //最大值
//        Optional<Hero> result = heroStream.reduce((h1, h2) -> h1.strength() > h2.strength() ? h1 : h2);
//        Optional<Hero> max = heroStream.max(Comparator.comparingInt(h1 -> h1.strength));
//        Optional<Hero> max = heroStream.max(Comparator.comparingInt(Hero::strength));
//        System.out.println(max);
//        System.out.println(result);

        //求对象总数
//        Integer sum = heroStream.map(h1 -> 1).reduce(0, (a, b) -> a + b);
//        long count = heroStream.count();
//        System.out.println(count);
//        System.out.println(sum);

        //求和
        int sum = heroStream.mapToInt(Hero::strength).sum();
        System.out.println(sum);

    }
}
