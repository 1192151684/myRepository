package com.sam.wms.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
public class SysGroup {

   private Integer id;

   private Integer parentId;

   private String  url;

   private String name;

   private Date  crateBy;

}
