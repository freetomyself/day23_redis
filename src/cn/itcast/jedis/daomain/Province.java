package cn.itcast.jedis.daomain;

/**
 * @program: day23_redis--cn.itcast.jedis.daomain
 * @author: WaHotDog 2019-07-11 08:28
 **/


public class Province {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
