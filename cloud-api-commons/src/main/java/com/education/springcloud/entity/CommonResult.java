package com.education.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 正能量导师
 * @version 1.0
 * @description json返回实体，T泛型封装
 * @date 24/1/2022 上午6:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
