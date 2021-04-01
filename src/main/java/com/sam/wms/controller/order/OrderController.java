package com.sam.wms.controller.order;

import com.sam.wms.common.enums.ResultType;
import com.sam.wms.common.utils.BaseController;
import com.sam.wms.dto.FBAInvertoryReqDTO;
import com.sam.wms.serivce.OrderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sam
 * date:2021.03.2021/3/10
 * time:3:33
 */
@RestController
public class OrderController extends BaseController {

    @Autowired
    OrderSevice orderSevice;

    @RequestMapping("/fba/Repertory")
    public String product(HttpServletRequest request, @RequestBody List<FBAInvertoryReqDTO> fbaInvertoryReqDtoList){

        orderSevice.checkOrder(fbaInvertoryReqDtoList);

        return toJson(fbaInvertoryReqDtoList);
    }
}
