package com.deepsea.concurrency.homework;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Homework03 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //以下是方法
      //  method1();
     //   method2();
    //    method3();
        method4();

    }

    public static void method1() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            public void run() {
                long start=System.currentTimeMillis();
                int result = sum(); //这是得到的返回值
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为："+result);

                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        latch.await();

    }

    public static Integer method2() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> runSum = new RunSum();
        Future<Integer> future = executorService.submit(runSum);
        executorService.shutdown();
        return future.get();
    }

    public static Integer method3() throws ExecutionException, InterruptedException {
        Callable<Integer> runSum = new RunSum();
        FutureTask<Integer> task = new FutureTask<Integer>(runSum);
        Thread thread = new Thread(task);
        thread.start();
        return task.get();
    }

    public static void method4() {
        ReenterLockCondition reenterLockCondition = new ReenterLockCondition();
        Thread thread = new Thread(reenterLockCondition);
        thread.start();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    static class RunSum implements Callable<Integer>{

        public Integer call() throws Exception {
            long start=System.currentTimeMillis();
            int result = sum();
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
            return result;
        }
    }

    static class ReenterLockCondition implements Runnable{
        public static ReentrantLock lock = new ReentrantLock();
        public static Condition condition = lock.newCondition();
        public void run() {
            try{
                lock.lock();
                long start=System.currentTimeMillis();
                int result = sum();
                System.out.println("异步计算结果为："+result);
                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
