package com.payment.processor.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class PaymentStateMachine extends EnumStateMachineConfigurerAdapter<PaymentState, PaymentEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<PaymentState, PaymentEvent> states) throws Exception {
        states
            .withStates()
            .initial(PaymentState.INITIATED)
            .states(EnumSet.allOf(PaymentState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<PaymentState, PaymentEvent> transitions) throws Exception {
        transitions
            .withExternal()
                .source(PaymentState.INITIATED).target(PaymentState.VALIDATED).event(PaymentEvent.VALIDATE)
            .and()
            .withExternal()
                .source(PaymentState.VALIDATED).target(PaymentState.PROCESSING).event(PaymentEvent.PROCESS)
            .and()
            .withExternal()
                .source(PaymentState.PROCESSING).target(PaymentState.COMPLETED).event(PaymentEvent.COMPLETE)
            .and()
            .withExternal()
                .source(PaymentState.PROCESSING).target(PaymentState.FAILED).event(PaymentEvent.FAIL);
    }
}
