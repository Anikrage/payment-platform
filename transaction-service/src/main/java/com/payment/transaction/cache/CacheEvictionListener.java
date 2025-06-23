package com.payment.transaction.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CacheEvictionListener {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @KafkaListener(topics = "cache-eviction")
    public void handleEviction(String cacheKey) {
        redisTemplate.delete(cacheKey);
    }
}
