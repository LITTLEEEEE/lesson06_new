package cn.edu.bussiness.monthFinish.controller;

import cn.edu.bussiness.monthFinish.service.impl.getmonthFinishServiceImpl;
import cn.edu.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * json2
 */
@RestController
@RequestMapping("/monthFinish")
public class monthFinishController {
    @Autowired
    private getmonthFinishServiceImpl getmonthFinishService;
    @CrossOrigin
    @RequestMapping("getFinish")
    public Result getmonthFinish(Result result){
        result.setSucessMessage("success",getmonthFinishService.getmonthFinish());
        return result;
    }
}
