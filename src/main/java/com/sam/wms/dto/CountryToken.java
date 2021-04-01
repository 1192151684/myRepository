package com.sam.wms.dto;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sam
 * date:2021.04.2021/4/1
 * time:21:10
 */
@Data
@Component
public class CountryToken {

   private String  countryCode;


   private List<String> SKUList;


}
