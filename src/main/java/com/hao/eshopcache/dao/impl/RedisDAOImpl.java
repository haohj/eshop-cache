package com.hao.eshopcache.dao.impl;

import com.hao.eshopcache.dao.RedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service("redisDAO")
public class RedisDAOImpl implements RedisDAO {
    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public void delete(String key) {
        jedisCluster.del(key);
    }
}
