package com.wangkai.service;


/**
 * Created by admin on 16/8/4.
 */
public class Command {

//    public static void main(String args[]){
//        //
////        Command command = new Command("Synchronous-hystrix");
////        //使用execute()同步调用代码,效果等同于:command.queue().get();
////        UserBean result = command.execute();
////        System.out.println("result=" + result);
////        //
////        command = new Command("Asynchronous-hystrix");
////        //异步调用,可自由控制获取结果时机,
////        Future<UserBean> future = command.queue();
////        //get操作不能超过command定义的超时时间,默认:1秒
////        try {
////            result = future.get(2000, TimeUnit.MILLISECONDS);
////            System.out.println("result=" + result);
////            System.out.println("mainThread=" + Thread.currentThread().getName());
////        } catch (InterruptedException e) {
////            //
////            System.out.println("InterruptedException");
////        } catch (ExecutionException e) {
////            //
////            System.out.println("ExecutionException");
////        } catch (TimeoutException e) {
////           //
////           System.out.println("TimeoutException");
////        }
//
//        int h;
//        Object key = "wangkai";
//        System.out.println(key.hashCode());
//        int hashCode = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        System.out.println(hashCode);
//        //
//        int n = 33 - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        int tableSize = (n < 0) ? 1 : n + 1;
//        System.out.println(tableSize);
//    }
}
