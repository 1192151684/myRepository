package com.sam.wms.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author sam
 * date:2021.04.2021/4/1
 * time:21:30
 */
@Data
@Component
public class FBAInvertoryReqDTO {


    private  String sku;


    @JsonProperty("seller_id")
    private String sellerId;


    @JsonProperty("country")
    private String countryCode;

}
