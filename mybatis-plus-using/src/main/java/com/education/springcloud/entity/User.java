package com.education.springcloud.entity;

import lombok.Data;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/2/2022 上午12:51
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
