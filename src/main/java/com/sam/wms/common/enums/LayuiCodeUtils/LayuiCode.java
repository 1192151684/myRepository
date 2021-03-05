package com.sam.wms.common.enums.LayuiCodeUtils;

import java.util.List;
import java.util.Map;

/**
 * @author sam
 * date:2021.03.2021/3/5
 * time:3:35
 */


public class LayuiCode <T>{

    private String cod;

    private String msg;

    private String count;

    private T data;

    public LayuiCode(String cod, String msg, String count, T data) {
        this.cod = cod;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public LayuiCode() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
