package com.education.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.education.springcloud.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/2/2022 上午12:53
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
