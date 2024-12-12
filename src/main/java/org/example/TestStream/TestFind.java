package org.example.TestStream;

import java.util.Arrays;

/**
 * 与 findAny 比较类似的是 firstFirst，它俩的区别
 *
 * * findAny 是找在流中任意位置的元素，不需要考虑顺序，对于上例返回 6 也是可以的
 * * findFirst 是找第一个出现在元素，需要考虑顺序，对于上例只能返回 4
 * * findAny 在顺序流中与 findFirst 表现相同，区别在于并行流下会更快
 */
public class TestFind {
    public static void main(String[] args) {
        /**
         * 下面的代码找到流中任意（Any）一个偶数
         * 注意 findAny 返回的是 OptionalInt 对象，因为可能流中不存在偶数
         * 对于 OptionalInt 对象，一般需要用 ifPresent 或 orElse（提供默认值）来处理
         */
        int[] arr={1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr).filter(x->(x&1)==0)
                .findAny()
                .ifPresent(System.out::println);
        //找到流中第一个偶数
        Arrays.stream(arr).filter(x->(x&1)==0)
                .findFirst()
                .ifPresent(s->System.out.println(s));
        //判断流中是否存在任意一个偶数
        boolean a = Arrays.stream(arr).anyMatch(x -> (x & 1) == 0);
        System.out.println(a);
        //判断流是否全部是偶数
        boolean b = Arrays.stream(arr).allMatch(x -> (x & 1) == 0);
        System.out.println(b);
        //判断流是否全部不是偶数
        boolean c = Arrays.stream(arr).noneMatch(x -> (x & 1) == 0);
        System.out.println(c);
    }
}
