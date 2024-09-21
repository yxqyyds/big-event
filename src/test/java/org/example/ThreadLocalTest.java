package org.example;

import org.junit.jupiter.api.Test;


public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet(){
        ThreadLocal tl=new ThreadLocal<>();

        new Thread(()->{tl.set("萧炎");
            System.out.println(Thread.currentThread()+":"+tl.get());
            System.out.println(Thread.currentThread()+":"+tl.get());
            System.out.println(Thread.currentThread()+":"+tl.get());},"蓝色").start();

        new Thread(()->{tl.set("管俊丞");
            System.out.println(Thread.currentThread()+":"+tl.get());
            System.out.println(Thread.currentThread()+":"+tl.get());
            System.out.println(Thread.currentThread()+":"+tl.get());},"绿色").start();

    }

}
