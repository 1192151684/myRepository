package com.sam.wms.entity;

import java.util.Date;

public class SysGroup {

   private Integer id;

   private Integer parentId;

   private String  url;

   private String name;

   private Date  crateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCrateBy() {
        return crateBy;
    }

    public void setCrateBy(Date crateBy) {
        this.crateBy = crateBy;
    }
}
