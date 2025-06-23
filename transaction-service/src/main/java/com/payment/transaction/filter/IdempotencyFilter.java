package com.payment.transaction.filter;

import java.io.IOException;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class IdempotencyFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String idempotencyKey = request.getHeader("Idempotency-Key");
        if (idempotencyKey != null) {
            if (Boolean.TRUE.equals(redisTemplate.hasKey(idempotencyKey))) {
                response.sendError(HttpStatus.CONFLICT.value(), "Duplicate request detected");
                return;
            }
            redisTemplate.opsForValue().set(idempotencyKey, "processed", Duration.ofMinutes(30));
        }
        filterChain.doFilter(request, response);
    }
}
