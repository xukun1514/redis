package com.huasheng;

import redis.clients.jedis.Jedis;

/**
 * @author XK
 *
 *测试是否可以连接成功
 */
public class TestPing {
    public static void main(String[] args) {
        /**
         * 1、创建一个Jedis对象即可
         */
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("ping："+jedis.ping());
        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.keys("*"));
        jedis.flushDB();
        System.out.println(jedis.keys("*"));

        //断开连接
        System.out.println(jedis.quit());
    }
}
