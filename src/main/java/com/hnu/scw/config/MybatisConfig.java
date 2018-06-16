package com.hnu.scw.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import javax.sql.DataSource;

/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 9:23 2018/6/13 0013
 * @ Description：配置mybatis内容
 * @ Modified By：
 * @Version: $version$
 */
@Configuration
public class MybatisConfig {
   @Autowired
    private DataSource mydataSource;

    @Bean(name = "sqlSessionFactory")
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        try {
            // 设置数据源
            sqlSessionFactoryBean.setDataSource(mydataSource);
            // 设置mybatis的主配置文件
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatis-config.xml");
            sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);

            //设置mybatis扫描的mapper.xml文件的路径（非常重要，否则找不到mapper.xml文件）
            Resource[] mapperResources = resolver.getResources("classpath:mybatis/mapper/*.xml");
            sqlSessionFactoryBean.setMapperLocations(mapperResources);
            // 设置别名包，便于在mapper.xml文件中ParemeType和resultType不要写完整的包名
            sqlSessionFactoryBean.setTypeAliasesPackage("com.hnu.scw.pojo");
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }
    }
}
