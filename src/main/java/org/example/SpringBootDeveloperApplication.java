package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/*
@SpringBootConfiguration: 설정 파일 등록
@ComponentScan: 사용자가 등록한 빈 등록
@EnableAutoConfiguration: 자동으로 등록된 빈을 읽고 등록(프레임워크에서 지원하는)
@EnableJpaAuditing: created_at, updated_at 자동 업데이트, 감사/심사, set or modify
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDeveloperApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
