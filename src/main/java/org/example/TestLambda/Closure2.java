package org.example.TestLambda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Closure2 {
    //闭包作用，给函数提供参数以外的数据
    public static void main(String[] args) throws IOException {
       //创建十个任务对象，给每个任务一个编号
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int k=i+1;
            Runnable task = ()-> System.out.println(Thread.currentThread().getName()+":执行任务"+k);
            list.add(task);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (Runnable task : list) {
            executorService.submit(task);
        }
        System.in.read();
    }
}
