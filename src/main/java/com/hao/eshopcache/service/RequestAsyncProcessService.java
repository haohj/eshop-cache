package com.hao.eshopcache.service;

import com.hao.eshopcache.request.Request;

/**
 * 请求异步执行的service
 *
 */
public interface RequestAsyncProcessService {
    void process(Request request);
}
