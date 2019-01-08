package com.wesocket.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketRegistry implements WebSocketConfigurer {
    public SocketRegistry(){
        System.out.println("SocketRegistry init");
    }
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("registerWebSocketHandlers init");
        registry.addHandler(new SocketHandler(),"/message");
    }
}
