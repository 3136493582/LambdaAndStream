package org.example.TestLambda;

public class Exersize {
    @FunctionalInterface
    interface Lambda{
        int add(int a, int b);
    }

    public static void main(String[] args) {
        Lambda c=(a,b)->a+b;
        System.out.println(c.add(1,2));
    }
}
