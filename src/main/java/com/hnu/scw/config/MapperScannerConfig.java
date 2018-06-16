package com.hnu.scw.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 9:28 2018/6/13 0013
 * @ Description：mapper扫描配置
 * @ Modified By：
 * @Version: $version$
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class) //保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {

    // mapper接口的扫描器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.hnu.scw.mapper");
        return mapperScannerConfigurer;
    }
}
