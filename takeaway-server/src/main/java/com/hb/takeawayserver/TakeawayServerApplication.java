package com.hb.takeawayserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hb.takeawayserver.mapper")
public class TakeawayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeawayServerApplication.class, args);
    }

}
