package cn.edu.config;

import cn.edu.core.druid.DruidProperties;
import cn.edu.core.util.DataSourceUtil;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author liuzh
 * @since 2017/2/5.
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidConfig {

    @Qualifier("druid-cn.edu.core.druid.DruidProperties")
    @Autowired
    private DruidProperties properties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = DataSourceUtil.generateDruidByPro(properties);
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
