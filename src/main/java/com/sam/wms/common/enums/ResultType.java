package com.sam.wms.common.enums;

public enum  ResultType implements BaseEnum<ResultType, String> {

    SUCCESS("1001", "成功"),

    SYSTEM_ERR("2001","系统异常"),

    OPERATION_FAIL("2002","操作失败");

    private String code;

    /** 枚举描述 */
    private String desc;

    private ResultType(final String code, final String desc) {
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
