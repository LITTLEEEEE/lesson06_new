package cn.edu.bussiness.labstu.controller;

import cn.edu.bussiness.labstu.service.impl.labstuServiceImpl;
import cn.edu.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * json7
 */
@RestController
@RequestMapping("/labstu")
public class labstuController {
    @Autowired
    labstuServiceImpl labstuService;

    @RequestMapping("getit")
    public Result getlabstu(Result result){
        result.setSucessMessage("success",labstuService.getlabstuModel());
        return result;
    }
}
