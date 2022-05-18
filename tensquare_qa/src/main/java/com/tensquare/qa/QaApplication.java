package com.tensquare.qa;

import com.tensquare.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Description: 启动类
 * @Author: cmj
 * @Date: 2022-03-02 16:59
 * @Version: V1.0
 */

@SpringBootApplication
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
