package com.sam.wms.mapper;

import com.sam.wms.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductMapper {

    List<Product> findProductList(Map<String,Object> paraMap);

}
