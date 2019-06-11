package cn.edu.core.util;

import cn.edu.core.druid.DruidProperties;
import com.alibaba.druid.pool.DruidDataSource;


/**
 * Created with family.
 * author: cy
 * Date: 18/10/31
 * Time: 上午10:04
 * description:
 */
public class DataSourceUtil {

    /**
     * 根据pro 构建 ds
     * @param properties
     * @return
     */
    public static DruidDataSource  generateDruidByPro(DruidProperties properties){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClass());
        if (properties.getInitialSize() > 0)
            dataSource.setInitialSize(properties.getInitialSize());
        if (properties.getMinIdle() > 0)
            dataSource.setMinIdle(properties.getMinIdle());
        if (properties.getMaxActive() > 0)
            dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());

        return dataSource;
    }
}
