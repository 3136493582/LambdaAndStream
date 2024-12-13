package org.example.TestStream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream收集
 * 收集：将元素收集入容器
 * .collect（（）->c，（c，x）->void，?)
 * (）->c创建容器C
 * （c，x）->void将元素X加入容器c
 */
public class TestCollect {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("独孤求败", "令狐冲", "风清扬", "东方不败", "方证", "任我行", "冲虚", "向问天", "不戒");
        //收集在一个数组列表
//        ArrayList<Object> collect = stream.collect(() -> new ArrayList<>(), (list, x) -> list.add(x), (list1, list2) -> {});

        //()->new ArrayList<>()  ArrayList::new
        //Array::add (list,x)->add
        //       ArrayList<Object> collect = stream.collect(ArrayList::new, ArrayList::add, (a, b) -> {});
//        LinkedHashSet<Object> collect = stream.collect(LinkedHashSet::new, LinkedHashSet::add, (a, b) -> {});
//        System.out.println(collect);

        //容器
//        StringBuffer collect = stream.collect(StringBuffer::new, StringBuffer::append, (a, b) -> {});
//        System.out.println(collect);

        //收集到map
        HashMap<Object, Object> collect = stream.collect(HashMap::new, (map, x) -> map.put(x, 1), (a, b) -> {});
        System.out.println(collect);
    }
}
