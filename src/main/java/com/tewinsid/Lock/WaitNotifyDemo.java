package com.tewinsid.Lock;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: tewinsid
 * @Description: 三种线程间协助机制
 * @Date: Created in 21:58 2020/7/31}
 */
public class WaitNotifyDemo {

    private List list;

    {
        list = Collections.synchronizedList(new ArrayList());
    }

    /**
     * 通过 wait notify 实现通知机制
     */
    @Test
    public void notifyMissing() throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        consumer.start();
        producer.start();
        TimeUnit.SECONDS.sleep(10);
    }

    /**
     * 通过 Lock Condtion实现通知机制
     */
    @Test
    public void LockConditionTest() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConsumerCondition consumer = new ConsumerCondition(lock, condition);
        ProducerCondition producer = new ProducerCondition(lock, condition);
        consumer.start();
        producer.start();
    }

    /**
     * 通过阻塞队列实现通知机制
     */
    @Test
    public void BlockingQueueTest() {
        LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue();
        ConsumerBlockQueue consumer = new ConsumerBlockQueue(blockingQueue);
        ProducerBlockQueue producer = new ProducerBlockQueue(blockingQueue);

        consumer.start();
        producer.start();
    }

    class ProducerBlockQueue extends Thread{
        BlockingQueue queue;

        ProducerBlockQueue(BlockingQueue blockingQueue) {
            this.queue = blockingQueue;
        }

        @Override
        public void run() {
            System.out.println("producer put");
            try {
                queue.put("111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ConsumerBlockQueue extends Thread{
        BlockingQueue queue;

        ConsumerBlockQueue(BlockingQueue blockingQueue) {
            this.queue = blockingQueue;
        }
        @Override
        public void run() {
            try {
                System.out.println("consumer start fetch");
                Object element = queue.take();
                System.out.println(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    class ProducerCondition extends Thread {
        ReentrantLock lock;
        Condition condition;
        ProducerCondition(ReentrantLock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println("ProducerCondition single");
            condition.signal();
            lock.unlock();
        }
    }

    class ConsumerCondition extends Thread {
        ReentrantLock lock;
        Condition condition;

        ConsumerCondition(ReentrantLock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            lock.lock();

            try {
                System.out.println("consumer await");
                condition.await();
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
            System.out.println("consumer finish");
            lock.unlock();
        }

    }



    class Producer extends Thread {
        @Override
        public void run() {
            synchronized (list) {
                list.add(Thread.currentThread().getName());
                System.out.println("producer gonna invoke notifyAll");
                list.notify();
                System.out.println("producer finish");
            }
        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            synchronized (list) {
                try {
                    System.out.println("consumer wait");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String producerThreadName = (String) list.get(0);
                System.out.println(producerThreadName);
            }
        }
    }

}
