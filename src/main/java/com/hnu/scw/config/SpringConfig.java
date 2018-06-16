package com.hnu.scw.config;
import com.alibaba.druid.pool.DruidDataSource;
import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;

/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 9:03 2018/6/13 0013
 * @ Description：用于配置数据库等配置文件
 * @ Modified By：
 * @Version: $version$
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringConfig {
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * 配置数据库
     * @return
     */
    @Bean(name = "mydataSource")
    public DataSource mydataSource(){
        DruidDataSource datasource = new DruidDataSource();
        // 数据库驱动
        datasource.setDriverClassName(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
        datasource.setUrl(jdbcUrl);
        // 数据库的用户名
        datasource.setUsername(jdbcUsername);
        // 数据库的密码
        datasource.setPassword(jdbcPassword);
        // 每个分区最大的连接数
        datasource.setMaxActive(20);
        // 每个分区最小的连接数
        datasource.setMinIdle(5);
        return datasource;
        /*
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        // 数据库驱动
        boneCPDataSource.setDriverClass(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
        boneCPDataSource.setJdbcUrl(jdbcUrl);
        // 数据库的用户名
        boneCPDataSource.setUsername(jdbcUsername);
        // 数据库的密码
        boneCPDataSource.setPassword(jdbcUsername);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);
        return boneCPDataSource;*/
    }
}
