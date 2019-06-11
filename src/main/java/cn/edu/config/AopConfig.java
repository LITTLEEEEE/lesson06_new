package cn.edu.config;


import cn.edu.core.app.PageUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lcy on 18/1/21.
 */
@Configuration
public class AopConfig {


    /**
     * 分页 bean
     * @return
     */
    @Bean
    public PageUtil pageUtil(){
        return new PageUtil();
    }


}
