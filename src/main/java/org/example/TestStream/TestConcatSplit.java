package org.example.TestStream;

import java.util.stream.Stream;

public class TestConcatSplit {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("a", "b", "c");
        Stream<String> b = Stream.of("d", "e", "f");
        //concat 拼接两个流
        Stream<String> concat = Stream.concat(a, b);
        System.out.println(concat);
        System.out.println("------------------------------------");
        //skip跳过几个元素,保留剩下的元素
      //  concat.skip(2).forEach(System.out::println);
        //limit保留n个剩下的不要
        concat.limit(2).forEach(System.out::println);
        //顺序局部过滤
        //dropwhile 条件成立的舍弃，一旦条件不成文，剩下的保留
        //takewhile 条件成立的保留，一旦条件不成立，剩下的保留
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        //integerStream.takeWhile(x->x<5).forEach(System.out::println);
        integerStream.dropWhile(x->x<5).forEach(System.out::println);
    }
}
