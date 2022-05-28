package com.cdp.common.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum StatusEnum implements IEnum<Integer> {

    SUCCESS(200,"操作成功"),
    ERROR(400,"操作失败"),
    NOTFOUND(404,"未找到"),
    DISABLED(0, "禁用"),
    ENABLE(1, "启用");



    private Integer value;
    private String desc;

    StatusEnum(int value, String desc) {
        this.value=value;
        this.desc=desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
