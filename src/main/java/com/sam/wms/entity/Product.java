package com.sam.wms.entity;

import java.util.Date;

public class Product {

    private Integer productId;

    private String productSku;

    private String  productName;

    private Integer productCount;

    private Date productCreateBy;

    private Integer productIsuse;

    private String productTypeName;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Date getProductCreateBy() {
        return productCreateBy;
    }

    public void setProductCreateBy(Date productCreateBy) {
        this.productCreateBy = productCreateBy;
    }

    public Integer getProductIsuse() {
        return productIsuse;
    }

    public void setProductIsuse(Integer productIsuse) {
        this.productIsuse = productIsuse;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
