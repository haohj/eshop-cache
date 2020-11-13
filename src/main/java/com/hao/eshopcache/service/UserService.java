package com.hao.eshopcache.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hao.eshopcache.dao.RedisDAO;
import com.hao.eshopcache.mapper.UserMapper;
import com.hao.eshopcache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 * @author haohj
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisDAO redisDAO;

    public User findUserInfo() {
        return userMapper.findUserInfo(1);
    }

    public User getCachedUserInfo() {
        redisDAO.set("cached_user_lisi", "{\"name\": \"lisi\", \"age\":28}");

        String userJson = redisDAO.get("cached_user_lisi");
        JSONObject userJsonObject = JSON.parseObject(userJson);

        User user = new User();
        user.setName(userJsonObject.getString("name"));
        user.setAge(userJsonObject.getInteger("age"));

        return user;
    }
}
