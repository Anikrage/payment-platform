package com.payment.resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerMetrics {

    @Bean
    public MeterBinder circuitBreakerMetrics(CircuitBreakerRegistry circuitBreakerRegistry) {
        return registry -> {
            circuitBreakerRegistry.getAllCircuitBreakers().forEach(circuitBreaker -> {
                // Example: registry.gauge(...)
                // See Resilience4j Micrometer docs for details
            });
        };
    }
}
