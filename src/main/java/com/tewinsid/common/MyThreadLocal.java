package com.tewinsid.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Description:
 * @Date: Created in 23:00 2021/2/6}
 */
public class MyThreadLocal {

    /**
     * 本质上还是通过加锁实现，有性能瓶颈
     * 静态资源
     */
    Map<Long, Map> threadMap = Maps.newConcurrentMap();


    public Object get(Object key) {
        Map innerMap = threadMap.get(Thread.currentThread().getId());
        if (innerMap == null) {
            return null;
        }
        return innerMap.get(key);
    }

    public void set(Object key, Object val) {
        Map innerMap = threadMap.get(Thread.currentThread().getId());

        if (innerMap == null) {
            innerMap = Maps.newHashMap();
            threadMap.put(Thread.currentThread().getId(), innerMap);
        }
        innerMap.put(key, val);
    }


}
