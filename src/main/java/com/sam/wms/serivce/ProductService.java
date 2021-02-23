package com.sam.wms.serivce;

import com.sam.wms.entity.Product;
import com.sam.wms.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    //商品列表
    public List<Product> findProductList(Map<String,Object> paramMap){
           List<Product> productList = productMapper.findProductList( paramMap);
        return productList;
    }



}
