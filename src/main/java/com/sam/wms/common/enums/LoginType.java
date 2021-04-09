package com.sam.wms.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author sam
 * date:2021.04.2021/4/8
 * time:14:50
 */
public enum LoginType implements BaseEnum<ResultType, String> {
    SUCCESS("1001", "成功"),

    ACCOUNT_REE("2002","用户名错误"),

    PASS_WORD("2003","密码错误");

    private String code;

    /** 枚举描述 */
    private String desc;


    private LoginType(final String code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getCode() {
        return code;
    }
}
