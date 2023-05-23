package com.github.udanton.algorithms.demo;

import java.io.IOException;

import com.github.udanton.algorithms.demo.bst.BSTDemoExecutor;
import com.github.udanton.algorithms.demo.sort.CountingSortExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AlgorithmsDemoApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AlgorithmsDemoApplication.class, args);
        applicationContext.getBean(BSTDemoExecutor.class).execute(100000);
        applicationContext.getBean(CountingSortExecutor.class).execute(1_000_000, 1_000_000);
        applicationContext.getBean(CountingSortExecutor.class).execute(5_000_000, 1_000_000);
        applicationContext.getBean(CountingSortExecutor.class).execute(10_000_000, 1_000_000);
    }

}
