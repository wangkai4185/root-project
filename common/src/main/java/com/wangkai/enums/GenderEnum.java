package com.wangkai.enums;

/**
 * Created by admin on 16/7/11.
 */
public enum GenderEnum {

    Unknown(0), Male(1), Female(2);
    public final int value;

    GenderEnum(int value) {
        this.value = value;
    }
}
