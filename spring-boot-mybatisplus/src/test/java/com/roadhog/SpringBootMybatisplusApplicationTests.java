package com.roadhog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roadhog.domin.User;
import com.roadhog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootMybatisplusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testQueryMapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("name");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);

    }

    @Test
    public void testInsert() {
        User user = new User(null, "张三", 23, "zhangsan@atguigu.com");
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("受影响行数：" + result);
        //1475754982694199298
        System.out.println("id自动获取：" + user.getId());
    }

    @Test
    public void testDeleteById() {
        //通过id删除用户信息 DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1574634203933077506L);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void testDeleteByMap() {
        //通过id删除用户信息 DELETE FROM user WHERE id=?
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 28);
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数：" + result);
    }
}
