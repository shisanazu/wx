package com.test.service.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisUtil {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public Object getBykey(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    public void addKey(String key,String object) {
        redisTemplate.opsForValue().set(key, object);
    }
    public void addKey(String key,String object, Long expires) {
        redisTemplate.opsForValue().set(key,object,expires, TimeUnit.SECONDS);
    }
}
