package com.hao.eshopcache.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 请求内存队列
 */
public class RequestQueue {
    /**
     * 内存队列
     */
    private List<ArrayBlockingQueue<Request>> queues = new ArrayList<ArrayBlockingQueue<Request>>();

    private static RequestQueue queue = new RequestQueue();

    private RequestQueue() {

    }

    public static RequestQueue getInstance() {
        return queue;
    }

    /**
     * 添加一个内存队列
     *
     * @param queue
     */
    public void addQueue(ArrayBlockingQueue<Request> queue) {
        this.queues.add(queue);
    }
}
