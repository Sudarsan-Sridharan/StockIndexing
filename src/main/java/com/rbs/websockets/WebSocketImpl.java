package com.rbs.websockets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import com.rbs.pojo.StockDetail;

@Component
public class WebSocketImpl extends BinaryWebSocketHandler {

	private Set<WebSocketSession> sessions = new HashSet();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		System.out.println("Message : " + message.getPayload());
	}
	
	public void sendStock(StockDetail stock){
		byte[] object = serializeObject(stock);
		for(WebSocketSession session : sessions)
			try {
				session.sendMessage(new BinaryMessage(object));
			} catch (IOException e) {e.printStackTrace();}
	}
	
	private static byte[] serializeObject(StockDetail obj){
	    ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
	    ObjectOutputStream oos;
	    byte[] bytes = null;
		try {
			oos = new ObjectOutputStream(bytesOut);
			oos.writeObject(obj);
		    oos.flush();
		    bytes = bytesOut.toByteArray();
		    bytesOut.close();
		    oos.close();		    
		} 	    
	    catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}
	
}
