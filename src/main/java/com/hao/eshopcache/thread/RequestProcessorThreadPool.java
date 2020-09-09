package com.hao.eshopcache.thread;

import com.hao.eshopcache.request.Request;
import com.hao.eshopcache.request.RequestQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestProcessorThreadPool {

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private static RequestProcessorThreadPool instance = new RequestProcessorThreadPool();

    private RequestProcessorThreadPool() {
        //请求内存队列
        RequestQueue requestQueue = RequestQueue.getInstance();
        for (int i = 0; i < 10; i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));
        }
    }

    public static RequestProcessorThreadPool getInstance() {
        return instance;
    }

    public static void init() {
        getInstance();
    }
}
