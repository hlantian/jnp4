package com.zxiaoyao.jnp4.thread;

import java.util.concurrent.*;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/4 14:54
 */
public class MultithreadedMaxFinder {
    public static void main(String[] args) {
        int[] data = {1,2345,5455,333,23323,4445,333445,44566};
        try {
            System.out.println(max(data));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if(data.length ==1){
            return data[0];
        }else if(data.length ==0){
            throw new IllegalArgumentException("数据错误");
        }

        FindMaxTask task1 = new FindMaxTask(data,0,data.length/2);
        FindMaxTask task2 = new FindMaxTask(data,data.length/2,data.length);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);
        return Math.max(future1.get(),future2.get());
    }
}
