package com.sc.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author: sc
 * @date: 2020/5/19
 */
@SpringBootTest
public class TestTX {
    @Test
    void Demo() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.56.102",6379);
        Transaction transaction = jedis.multi();//被当作一个命令进行执行

//        transaction.set("k4","v4");
//        transaction.set("k5","v5");
//        transaction.exec(); //事务正常执行

        transaction.set("k44","v44");
        transaction.set("k55","v55");
        transaction.discard(); //事务的不执行
    }
}
