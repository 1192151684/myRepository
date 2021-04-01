package com.sam.wms.controller.product;

import com.github.pagehelper.PageInfo;
import com.sam.wms.common.enums.ResultType;
import com.sam.wms.common.utils.BaseController;
import com.sam.wms.entity.Product;
import com.sam.wms.mapper.ProductMapper;
import com.sam.wms.serivce.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/product/product")
    public String product(HttpServletRequest request, Model model,@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        Map<String,Object> paramMap = new HashMap<String,Object>();
        PageInfo<Product> page  =  productService.findProductList(paramMap, pageNo, pageSize);
        model.addAttribute("pageInfo", page);
        return "product/product_product";
    }

    @PostMapping("/product/productdel")
    @ResponseBody
    public String delProduct(HttpServletRequest request,ModelAndView  mav){
      String prdocutIdStr =  request.getParameter("prdocutId");

      try {
          Integer prdocutId = Integer.parseInt(prdocutIdStr);
          productMapper.editProduct(prdocutId);

          return  toJson(resultMassage(ResultType.SYSTEM_ERR.getCode(),ResultType.SYSTEM_ERR.getDesc(),null));
      }catch (Exception e){
          return  toJson(resultMassage(ResultType.SYSTEM_ERR.getCode(),ResultType.SYSTEM_ERR.getDesc(),null));
      }
    }
}
