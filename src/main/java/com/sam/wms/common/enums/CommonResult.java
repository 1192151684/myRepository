package com.sam.wms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sam
 * date:2021.02.2021/2/26
 * time:0:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private String code;

    private String message;

    private T data;
}
