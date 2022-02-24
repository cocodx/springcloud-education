package com.education.springcloud.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 描述对象的数据
 * @date 24/2/2022 上午1:23
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(System.currentTimeMillis()),metaObject);
        this.setFieldValByName("updateTime",new Date(System.currentTimeMillis()),metaObject);
        this.setFieldValByName("version",1,metaObject);
        //0.正常，1删除
        this.setFieldValByName("deleted",0,metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(System.currentTimeMillis()),metaObject);
    }
}
