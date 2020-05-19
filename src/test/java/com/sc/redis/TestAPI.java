package com.sc.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author: sc
 * @date: 2020/5/19
 */
@SpringBootTest
public class TestAPI {

    @Test
    void Demo() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.56.102",6379);

        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        System.out.println("k3="+jedis.get("k3"));

        Set<String> sets = jedis.keys("*");
        System.out.println(sets.size());
    }
}
