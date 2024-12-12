package org.example.TestLambda;

import java.util.ArrayList;
import java.util.List;

public class Carrying2 {
    @FunctionalInterface
    interface F1{
        F2 addlist(List<Integer> a);
    }
    @FunctionalInterface
    interface F2{
F3 addlist(List<Integer> b);
    }
    @FunctionalInterface
    interface F3{
List<Integer> addlist(List<Integer> c);
    }
    static F2 step1(){
        List<Integer> x = List.of(1,2,3);
        F1 f1=a->b->c -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(a);
            list.addAll(b);
            list.addAll(c);
            return list;
        };
        return f1.addlist(x);
    }
    static F3 step2(F2 f2){
        List<Integer> y = List.of(4,5,6);
        return f2.addlist(y);
    }
    static List<Integer> step3(F3 f3){
        List<Integer> z = List.of(7,8,9);
        return f3.addlist(z);
    }

    public static void main(String[] args) {
        List<Integer> integers = step3(step2(step1()));
        System.out.println(integers);
    }
}
