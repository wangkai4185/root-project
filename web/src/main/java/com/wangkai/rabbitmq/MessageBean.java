package com.wangkai.rabbitmq;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 16/8/12.
 */
public @Data class MessageBean implements Serializable {

    private int id;

    private String name;

}
