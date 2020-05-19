package com.sc.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

/**
 * @author: sc
 * @date: 2020/5/19
 *  主从复制
 */
@SpringBootTest
public class TestMS {

    @Test
    void Demo() {
        //连接本地的 Redis 服务
        Jedis jedis_M = new Jedis("192.168.56.102",6379);
        Jedis jedis_S = new Jedis("192.168.56.102",6380);

        jedis_S.slaveof("192.168.56.102",6379); //制定从服务器
        jedis_M.set("class","1122"); //主写
        //第一次读的时候由于内存太快了，可能读到的数据是null，第二次读的时候就没问题了
        String result =  jedis_S.get("class"); //从读
        System.out.println(result);

    }
}
