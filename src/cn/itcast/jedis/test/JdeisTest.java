package cn.itcast.jedis.test;

import cn.itcast.jedis.utils.JedisUtils;
import cn.itcast.jedis.utils.JxlsUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: day23_redis--cn.itcast.jedis.test
 * @author: WaHotDog 2019-07-10 09:50
 **/


public class JdeisTest {
    @Test
    public void test(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","zhangsan");
        jedis.hset("user","age","18");
        jedis.setex("activity",20,"123");
        jedis.hset("user","gender","male");
        //获取hash
        String s = jedis.hget("user", "name");
        System.out.println(s);
        //获取user中的所有数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            System.out.println(key+":"+user.get(key));
        }
        //通过另一种方式获取map数据
        for (Map.Entry<String, String> entry : user.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //关闭jedis
        jedis.close();
    }

    @Test
    public void test1(){

        Jedis jedis = JedisUtils.getJedis();

        jedis.set("hehe","haha");

        jedis.close();

    }
    @Test
    public void test2(){
        // 模板路径和输出流
        String templatePath = "f:/template.xls";
        OutputStream os = null;
        try {
            os = new FileOutputStream("f:/out.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 定义一个Map，往里面放入要在模板中显示数据
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", "001");
        model.put("name", "张三");
        model.put("age", 18);
        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
        try {
            JxlsUtils.exportExcel(templatePath, os, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("完成");
    }
}
