package com.sam.wms.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
public class Product {

    private Integer productId;

    private String productSku;

    private String  productName;

    private Integer productCount;

    private Date productCreateBy;

    private Integer productIsuse;

    private String productTypeName;

}
