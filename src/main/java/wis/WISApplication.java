package wis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync(mode = AdviceMode.ASPECTJ)
@EnableScheduling
@EnableJpaRepositories("my.package.base.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EntityScan("my.package.base.*")   
public class WISApplication {

    public static void main(String[] args) {
        SpringApplication.run(WISApplication.class, args);
    }

    public static String isEmpty(String s){
        boolean b = org.apache.commons.lang.StringUtils.isEmpty(s);
        if(b){
            return "";
        }
        return s;
    }
}