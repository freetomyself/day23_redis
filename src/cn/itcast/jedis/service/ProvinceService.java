package cn.itcast.jedis.service;

import cn.itcast.jedis.daomain.Province;

import java.util.List;

/**
 * @program: day23_redis--cn.itcast.jedis.service
 * @author: WaHotDog 2019-07-11 08:33
 **/


public interface ProvinceService {
    List<Province> finAll();
    String findProvince_json();
}
