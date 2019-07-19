package cn.itcast.jedis.dao.impl;

import cn.itcast.jedis.dao.ProvinceDao;
import cn.itcast.jedis.daomain.Province;
import cn.itcast.jedis.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @program: day23_redis--cn.itcast.jedis.dao.impl
 * @author: WaHotDog 2019-07-11 08:31
 **/


public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> finAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
