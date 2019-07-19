package cn.itcast.jedis.dao;

import cn.itcast.jedis.daomain.Province;

import java.util.List;

/**
 * @program: day23_redis--cn.itcast.jedis.dao
 * @author: WaHotDog 2019-07-11 08:30
 **/


public interface ProvinceDao {
    List<Province> finAll();
}
