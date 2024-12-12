package org.example.TestLambda;

/**
 * 闭包就是**函数对象**与**外界变量**绑定在一起，形成的整体
 */
public class Closure {
    @FunctionalInterface
    interface Lambda{
        int add(int y);
    }

    public static void main(String[] args) {
        int x=10;
        highOrder(y->x+y);
    }

    static void highOrder(Lambda lambda){
        System.out.println(lambda.add(20));
    }
}
