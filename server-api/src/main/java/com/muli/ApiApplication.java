package com.muli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//Entity를 인식하지 못하여 scan을 진행
@EntityScan("com.common")
//다른 패키지의 bean을 등록하기 위한 작업
@SpringBootApplication(scanBasePackages = {
        "com.common",
        "com.muli"
})
//JpaRepository를 bean으로 등록하기 위한 작업 이부분은 DataSourceConfig에서 별도로 관리해도 됨
@EnableJpaRepositories(
        basePackages = {
                "com.common",
        }
)
@EnableDiscoveryClient
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
