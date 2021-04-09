package com.sam.wms.controller.order;


import com.sam.wms.common.utils.BaseController;
import com.sam.wms.serivce.OrderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sam
 * date:2021.03.2021/3/10
 * time:3:33
 */
@RestController
public class OrderController extends BaseController {

    @Autowired
    OrderSevice orderSevice;

    @RequestMapping("/fba/repertory")

    public String product(HttpServletRequest request){

        return null;
    }
}
