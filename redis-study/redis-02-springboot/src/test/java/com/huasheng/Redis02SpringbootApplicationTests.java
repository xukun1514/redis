package com.huasheng;

import com.huasheng.entity.User;
import com.huasheng.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    //1、注入RedisTemplate
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {

        /**
         * opsForValue()：操作String
         * opsForList()：操作List
         * opsForHash()：操作Hash
         * opsForSet()：操作Set
         * opsForZSet()：操作ZSet
         */

        //操作String
        redisTemplate.opsForValue().set("k1", "v1");
        System.out.println("k1:" + redisTemplate.opsForValue().get("k1"));

        //保存一个User对象
        User user = new User(1, "张三");
        redisTemplate.opsForValue().set(String.valueOf(user.getId()), user);
        System.out.println("user" + user.getId() + "：" + redisTemplate.opsForValue().get(String.valueOf(user.getId())));

        boolean result = redisUtils.set("name", "lisi");
        if (result){
            System.out.println(redisUtils.get("name"));
        }

    }

}
