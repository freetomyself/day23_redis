package cn.itcast.jedis.service.impl;

import cn.itcast.jedis.dao.ProvinceDao;
import cn.itcast.jedis.dao.impl.ProvinceDaoImpl;
import cn.itcast.jedis.daomain.Province;
import cn.itcast.jedis.service.ProvinceService;
import cn.itcast.jedis.utils.JedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @program: day23_redis--cn.itcast.jedis.service.impl
 * @author: WaHotDog 2019-07-11 08:34
 **/


public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> finAll() {
        return dao.finAll();
    }

    @Override
    public String findProvince_json() {
        //调用jedis工具类
        Jedis jedis = JedisUtils.getJedis();
        //查询jedis.
        String province_json = jedis.get("province_json");
        if (province_json==null){
            System.out.println("redis中缓存数据不存在.....");
            List<Province> ps = dao.finAll();
            //将ps序列化json格式
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
                //将数据存入redis
                jedis.set("province_json",province_json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("redis中已存在缓存....");
        }

        return province_json;
    }
}
