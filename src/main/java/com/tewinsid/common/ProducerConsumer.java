package com.tewinsid.common;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Date: Created in 00:01 2021/2/22}
 */
public class ProducerConsumer {


    @Test
    public void test() throws InterruptedException {
        List list = Lists.newArrayList();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread consumerThread1 = new Thread(new Consumer(list, lock, condition));
        Thread producerThread = new Thread(new Producer(list, lock, condition));
        consumerThread1.start();
        producerThread.start();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void binSearch() {
        int[] origin = {1, 2, 3, 4};
        int target = 2;
        int left = 0;
        int right = origin.length - 1;
        while (right >= left) {
            int middle = (left + right) / 2;
            if (origin[middle] == target) {
                System.out.println(middle);
                return;
            }
            if (origin[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
    }

    class MyQueue {

        public synchronized void put() {

        }

        public void task() {

        }
    }

    class Producer implements Runnable {

        private List queue;
        private Lock lock;
        private Condition condition;

        public Producer(List queue, Lock lock, Condition condition) {
            super();
            this.queue = queue;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            if (lock != null) {
                lock.lock();
            }
            try {
                queue.add("111");
                System.out.println("put 111");
                condition.signal();
            } finally {
                if (lock != null) {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        private List queue;
        private Lock lock;
        private Condition condition;

        public Consumer(List queue, Lock lock, Condition condition) {
            super();
            this.queue = queue;
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            if (lock != null) {
                lock.lock();
            }
            try {
                condition.await();
                System.out.println(queue.get(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock != null) {
                    lock.unlock();
                }
            }
        }
    }
}
