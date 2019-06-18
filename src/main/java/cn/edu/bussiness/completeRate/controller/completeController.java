package cn.edu.bussiness.completeRate.controller;

import cn.edu.bussiness.completeRate.service.comRateService;
import cn.edu.bussiness.completeRate.service.impl.comRateServiceImpl;
import cn.edu.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * json4、5
 */
@RestController
@RequestMapping("/completeRate")
public class completeController {
    @Autowired
    private comRateServiceImpl comRateService;

    @RequestMapping("gettoday")
    public Result getRate(Result result){
        result.setSucessMessage("success",comRateService.getComRate());
        return result;
    }
    @RequestMapping("getyesterday")
    public Result getRate_yesterday(Result result){
        result.setSucessMessage("success",comRateService.getComRate_yesterday());
        return result;
    }
}
