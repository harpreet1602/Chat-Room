package com.chat.app.chatroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
        registry.addEndpoint("/server1").withSockJS();
    }
//    to connect with server  /server1
//    to send message:      /app/message
//                          {}

//    to subscribe so that we can receive messages      /topic/return-to
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");

    }
}


