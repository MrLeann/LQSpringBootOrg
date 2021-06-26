package com.lq.lqspringbootorg.org;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class StringTest {

    public static  ReentrantLock lock= new ReentrantLock();;

    public static void main(String[] args) {

        Refrence r1 = new Refrence();
        Refrence r2 = new Refrence();

        System.out.println(r1==r2);
        synchronized (StringTest.class){

        }


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        new Thread(()->{
            try {
                lock.lock();
                lock.lock();
                System.out.println("StringTest.main");
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println("StringTest.main");
            }finally {
                lock.unlock();
            }
        }).start();



    }


}
