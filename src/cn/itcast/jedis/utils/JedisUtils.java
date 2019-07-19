package cn.itcast.jedis.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: day23_redis--cn.itcast.jedis.utils
 * @author: WaHotDog 2019-07-10 16:50
 **/


public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        Properties pro = new Properties();
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));

    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
