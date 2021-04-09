package com.sam.wms.serivce;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Product> findProductList(Map<String,Object> paramMap ,int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Product> productList = productMapper.findProductList(paramMap);
        PageInfo<Product> page = new PageInfo<Product>(productList);
        return page;
    }
}
