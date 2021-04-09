package com.sam.wms.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMassage<T> {

    private String code;

    private String message;

    private T data;
}

