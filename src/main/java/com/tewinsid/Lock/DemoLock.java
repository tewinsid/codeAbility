package com.tewinsid.Lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: tewinsid
 * @Description:
 * @Date: Created in 11:42 2020/5/26}
 */
public class DemoLock{
    private Sync sync;

    {
        sync = new Sync();
    }

    public void lock() {
        sync.acquire(1);
    }


    class Sync extends AbstractQueuedSynchronizer {


        @Override
        protected boolean tryAcquire(int arg) {
            // 尝试加锁
            int state = this.getState();
            if (state == 0) {
                compareAndSetState(0, 1);
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }
    }



}
