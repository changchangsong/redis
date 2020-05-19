package com.sc.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: sc
 * @date: 2020/5/19
 *  Jedis连接池
 */
public class JedisPoolUtil {
    private static  volatile JedisPool jedisPool = null;

    public JedisPoolUtil() {}

    public  static JedisPool getJedisPoolInstance(){
        if(null==jedisPool){
            synchronized (JedisPool.class){
                if(null == jedisPool){
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    //是否启用后进先出, 默认true
                    poolConfig.setLifo(true);
                    //最大空闲连接数, 默认8个
                    poolConfig.setMaxIdle(8);
                    //最大连接数, 默认8个
                    poolConfig.setMaxTotal(8);
                    //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
                    poolConfig.setMaxWaitMillis(-1);
                    //在获取连接的时候检查有效性, 默认false
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig,"192.168.56.102",6379);
                }
            }
        }
        return jedisPool;
    }

    public  static void release(JedisPool jedisPool,Jedis jedis){
        if(null != jedis){ //移除线程
            jedisPool.returnResourceObject(jedis);
        }
    }
}
