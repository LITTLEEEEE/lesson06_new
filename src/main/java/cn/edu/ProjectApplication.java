package cn.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lcy on 17/8/9.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableScheduling
@MapperScan(basePackages = "cn.edu.**.dao")//扫描dao 不需要@repository
public class ProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjectApplication.class, args);
    }
}
