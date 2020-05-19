package com.sc.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author: sc
 * @date: 2020/5/19
 */
@SpringBootTest
public class TestPool {
    @Test
    void Demo() {
        //获取jedis线程池
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            //往线程池中获取获取一个jedis
            jedis = jedisPool.getResource();
            jedis.set("aa","bb");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //将jedis往jedisPool中移除
            JedisPoolUtil.release(jedisPool,jedis);
        }
    }
}
