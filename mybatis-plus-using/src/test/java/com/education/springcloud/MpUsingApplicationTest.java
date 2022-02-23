package com.education.springcloud;

import com.education.springcloud.entity.User;
import com.education.springcloud.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
}
