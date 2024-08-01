package top.javatool.canal.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CanalExampleApplication {


    public static void main(String[] args) {

        SpringApplication.run(CanalExampleApplication.class, args);
    }



}
