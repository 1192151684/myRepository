package com.sam.wms.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {

    private Integer  id;

    private Integer math;

    private Integer chinese;

    private Integer english;

    private String name;

}
