package com.example.demor;

import com.example.demor.Entities.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RequiredArgsConstructor
@Configuration
public class Controller {

    private final ReactiveRedisTemplate<String, Entity> redisTemplate;

    @Bean
    RouterFunction<ServerResponse> getById() {
        return route(GET("/data/{id}"),
                req -> ok().body(redisTemplate.opsForValue().get(req.pathVariable("id")), Entity.class));
    }



}
