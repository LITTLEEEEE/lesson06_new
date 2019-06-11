package cn.edu.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/*
@Configuration
@EnableTransactionManagement
*/
public class TransactionConfig implements TransactionManagementConfigurer {
    /*@Autowired
    @Qualifier("txManagerOracle")*/
    private PlatformTransactionManager platformTransactionManager;

    // 创建Mysql事务管理器
    /*@Bean(name = "txManagerMysql")
    public PlatformTransactionManager txManagerMysql(@Qualifier("power") DataSource power) {
        return new DataSourceTransactionManager(power);
    }*/

    // 创建Oracle事务管理器
    /*@Bean(name = "txManagerOracle")
    public PlatformTransactionManager txManagerOracle(@Qualifier("pmiss") DataSource pmiss) {
        return new DataSourceTransactionManager(pmiss);
    }*/

    @Bean(name = "newManager")
    public PlatformTransactionManager newManager(@Qualifier("dataSource") DataSource dataSource) {
        PlatformTransactionManager ps = new DataSourceTransactionManager(dataSource);
        this.platformTransactionManager = ps;
        return platformTransactionManager;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return platformTransactionManager;
    }

    /**
     * 配置事务管理器
     */
    /*@Bean
    public DataSourceTransactionManager transactionManager(CyDynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }*/
}
