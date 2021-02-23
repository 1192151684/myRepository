package com.sam.wms.controller.product;

import com.sam.wms.common.utils.BaseController;
import com.sam.wms.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController extends BaseController {
    @Autowired
    ProductService productService;


    @RequestMapping("/product/product")
    public String product(HttpServletRequest request){


        return "system_system";
    }
}
