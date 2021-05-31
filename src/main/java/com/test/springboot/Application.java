package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //jpa auditing 활성화
@SpringBootApplication //스프링 부트 자동 설정, 스프링빈 읽기와 생성 모두 자동으로 설정
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        //SpringBootApplication.run 으로 인해 내장 WAS 실행
    }
}
