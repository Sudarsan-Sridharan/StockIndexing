package com.rbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.rbs.websockets.WebSocketImpl;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired WebSocketImpl websocketImpl;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(websocketImpl, "/stock");
	}

}
