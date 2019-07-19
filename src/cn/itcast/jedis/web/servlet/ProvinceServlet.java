package cn.itcast.jedis.web.servlet;

import cn.itcast.jedis.daomain.Province;
import cn.itcast.jedis.service.ProvinceService;
import cn.itcast.jedis.service.impl.ProvinceServiceImpl;
import cn.itcast.jedis.utils.JedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @program: day23_redis--${PACKAGE_NAME}
 * @author: WaHotDog 2019-07-11 08:49
 **/


@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1调用service
        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> list = service.finAll();
//        //2将list序列化为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
        String province_json = service.findProvince_json();
        System.out.println(province_json);
        response.setContentType("application/json;charset=utf-8");
        //3将数据返回给前端
        response.getWriter().write(province_json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
