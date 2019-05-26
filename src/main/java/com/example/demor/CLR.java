package com.example.demor;

import com.example.demor.Entities.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

@RequiredArgsConstructor
public class CLR implements CommandLineRunner {

    private final ReactiveRedisTemplate<String, Entity> redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("data1", new Entity().setName("Denis")).subscribe();
        redisTemplate.opsForValue().set("data2", new Entity().setName("Denis")).subscribe();
        redisTemplate.opsForValue().set("data3", new Entity().setName("Denis")).subscribe();
        redisTemplate.opsForValue().set("data10", new Entity().setName("Denis")).subscribe();

    }
}
