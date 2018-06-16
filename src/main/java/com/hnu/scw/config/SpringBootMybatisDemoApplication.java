package com.hnu.scw.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Springboot项目的运行入口
 */
@SpringBootApplication(scanBasePackages = "com.hnu.scw")
@EnableTransactionManagement  //开启事务管理
public class SpringBootMybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisDemoApplication.class, args);
	}
}
