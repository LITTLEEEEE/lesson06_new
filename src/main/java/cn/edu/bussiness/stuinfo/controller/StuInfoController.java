package cn.edu.bussiness.stuinfo.controller;

import cn.edu.core.model.Result;
import cn.edu.bussiness.stuinfo.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * json1、2
 */
@RestController
@RequestMapping("/stuinfo")
public class StuInfoController {

    @Autowired
    private StuInfoService stuInfoServiceImpl;


    @RequestMapping("/hello")
    public Result hello(Result result){
        int[] k = new int[]{3};
        result.setSucessMessage("200", Arrays.asList(2,3,4,5,5).toArray());
        return  result;
    }

    /**
     *  今日活跃度 top 10
     * @param result
     * @return
     */
    @RequestMapping("/query")
    public Result query(Result result){
        result.setSucessMessage("",stuInfoServiceImpl.query());
        return result;
    }

    /**
     * 课程完成率
     */
    @RequestMapping("/rate")
    public Result getCompleteRate(Result result){
        result.setSucessMessage("success",stuInfoServiceImpl.getCompleteRate());
        return result;
    }
}
