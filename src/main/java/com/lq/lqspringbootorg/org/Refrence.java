package com.lq.lqspringbootorg.org;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 弱引用示例
 */
public class Refrence {

    /**
     * 测试用例
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        ThreadLocal<Object> threadLocal;
        threadLocal = new ThreadLocal<>();
        //        threadLocal.set(123);
        //        threadLocal  = null;
        Object o33 = new Object();

        Object oject = new Object();



        // 强引用
//        Object o = new Object();
//        Object other = o;
//        System.out.println(o);
//        o=null;
//        System.gc();
//        System.out.println(other);

        // 软引用，除非内存满了才会被回收(常常用来做缓存)
        Object o2 = new Object();
        AtomicInteger atomicInteger = new AtomicInteger();
        final Object o3 = new Object();
        List<SoftReference> list = new ArrayList<>();
        IntStream.range(0, 10000).forEach(item -> {
            if (atomicInteger.incrementAndGet() < 1000) {
                list.add(new SoftReference<>(o3));
            }
        });

        ArrayList<Object> objects1 = new ArrayList<>();

        System.out.println(o2);
        o2 = null;
        List<Object> objects = new ArrayList<>();

        for (int i = 0; i < 1015; i++) {
            objects.add(new Object());
        }
//        System.gc();
        list.forEach(item -> {
            System.out.println(item.get());
        });

        //弱引用，触发垃圾回收就会被回收 (举例应用：ThreaLocal类就是继承WeakReference类，为什么要用弱引用？)
//        Object o3 = new Object();
//        WeakReference<Object> weakReference = new WeakReference<>(o3);
//        System.out.println(o3);
//        o3 = null;
//        System.gc();
//        System.out.println(weakReference.get());

        //虚引用
//        Object o4 = new Object();
//        ReferenceQueue referenceQueue = new ReferenceQueue();
//        PhantomReference phantomReference = new PhantomReference(o4,referenceQueue);
        System.in.read();



    }
}
