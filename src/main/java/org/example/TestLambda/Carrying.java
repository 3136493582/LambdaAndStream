package org.example.TestLambda;

//柯里化的作用是让函数对象分步执行（本质上是利用多个函数对象和闭包）
public class Carrying {
    @FunctionalInterface
    interface Step1{
        Step2 exec(int a);
    }
    @FunctionalInterface
    interface Step2{
        int exec(int b);
    }

    static void highOrder(Step1 s1){
        Step2 s2=s1.exec(10);
        System.out.println(s2.exec(20));
        System.out.println(s2.exec(50));
    }

    public static void main(String[] args) {
        highOrder(a->b->a+b);
    }
}
