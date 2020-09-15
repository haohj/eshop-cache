package com.hao.eshopcache.dao;

public interface RedisDAO {

    void set(String key, String value);

    String get(String key);

    void delete(String key);
}
