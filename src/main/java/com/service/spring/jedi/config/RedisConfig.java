package com.service.spring.jedi.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {

    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap.put("starshipName", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)));
            configurationMap.put("planetName", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)));
            configurationMap.put("personName", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)));
            configurationMap.put("personId", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)));
            configurationMap.put("starshipId", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)));
            builder.withInitialCacheConfigurations(configurationMap);
        };
    }

}