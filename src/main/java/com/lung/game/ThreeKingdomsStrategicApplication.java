package com.lung.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Multiple Spring Data modules found, entering strict repository configuration mode!
 */
@EnableMongoRepositories(basePackages = "com.lung.game.repository")
@EnableRedisRepositories(basePackages = "com.lung.game.cache")

/**
 * @link @SpringBootApplication contain @ComponentScan
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.lung.game")
public class ThreeKingdomsStrategicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreeKingdomsStrategicApplication.class, args);
    }

}
