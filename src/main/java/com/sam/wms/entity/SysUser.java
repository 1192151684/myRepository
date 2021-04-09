package com.sam.wms.entity;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SysUser {

    private Integer id;

    private String account;

    private String name;

    private String password;

    private String email;

}
