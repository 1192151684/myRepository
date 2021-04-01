package com.sam.wms.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sam
 * date:2021.04.2021/4/1
 * time:21:09
 */
@Data
@Component
public class Seller {

     private String sellerId;

     private List<CountryToken> countryTockenList;

}
