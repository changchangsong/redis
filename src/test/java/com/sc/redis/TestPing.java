package com.sc.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class TestPing {

    @Test
    void Demo() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.56.102",6379);
        //查看服务是否运行，打出pong表示OK
        System.out.println("connection is OK==========>: "+jedis.ping());
    }

}
