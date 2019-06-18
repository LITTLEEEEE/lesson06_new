package cn.edu.bussiness.Experimental.controller;

import cn.edu.bussiness.Experimental.service.impl.ExperimentalServiceImpl;
import cn.edu.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * json6
 */
@RestController
@RequestMapping("/experimental")
public class ExperimentalController {
    @Autowired
    private ExperimentalServiceImpl experimentalService;

    @RequestMapping("getreview")
    public Result getRate(Result result){
        result.setSucessMessage("success",experimentalService.getexper());
        return result;
    }

}
