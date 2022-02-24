package com.education.springcloud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.springcloud.entity.User;
import com.education.springcloud.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/2/2022 上午12:56
 */
@SpringBootTest
public class MpUsingApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setName("雪峰");
        user.setAge(25);
        user.setEmail("111111@gmail.com");
        userMapper.insert(user);
    }

    //先读后改
    @Test
    public void updateUser(){
        User user = userMapper.selectById(1496533042804662276L);
        user.setName("zhangsan1111");
        user.setAge(25);
        user.setEmail("860721890@qq.com");
        userMapper.updateById(user);
    }

    //根据id集合查询
    @Test
    public void selectByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }

    @Test
    public void selectByMap(){
        Map<String,Object> param = new HashMap<>();
        param.put("25","25");
        List<User> users = userMapper.selectByMap(param);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByPage(){
        Page<User> page = new Page<>(1,3);

        IPage<User> userIPage = userMapper.selectPage(page,null);

        List<User> users = userIPage.getRecords();
        users.forEach(System.out::println);
        System.out.println(userIPage.getCurrent());
        System.out.println(userIPage.getPages());
        System.out.println(userIPage.getSize());
        System.out.println(userIPage.getTotal());
    }

    @Test
    public void testDelete(){
//        int i = userMapper.deleteById(1496533042804662276L);
//        System.out.println(i);
        int j = userMapper.deleteBatchIds(Arrays.asList(1,2,3));
        System.out.println(j);
    }

    //逻辑删除,把状态改掉
    @Test
    public void delete(){
        userMapper.deleteById(1496533042804662277L);
    }

    //eq,ne
    @Test
    public void selectByInfo(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","雪峰");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
