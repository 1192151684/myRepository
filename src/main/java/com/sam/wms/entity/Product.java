package com.sam.wms.entity;

public class Product {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBproduct_code() {
        return bproduct_code;
    }

    public void setBproduct_code(String bproduct_code) {
        this.bproduct_code = bproduct_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    private String bproduct_code;

    private String product_name;

    private String  sku;
}
