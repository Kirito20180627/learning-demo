package com.ldy.design_pattern.observer.spring_mode;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class OrderEvent extends ApplicationEvent {

    public OrderEvent(Object source) {
        super(source);
    }

}
