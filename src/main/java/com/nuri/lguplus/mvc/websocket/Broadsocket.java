package com.nuri.lguplus.mvc.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint("/broadsocket")
public class Broadsocket {
//유저 집합 리스트
static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());

	/**
	 * 웹 소켓이 접속되면 유저리스트에 세션을 넣는다.
	 * 
	 * @param userSession 웹 소켓 세션
	 */
	@OnOpen
	public void handleOpen(Session userSession) {
		sessionUsers.add(userSession);
	}
	
	/**
	* 웹 소켓으로부터 메시지가 오면 호출한다.
	* @param message 메시지
	* @param userSession
	* @throws IOException
	*/
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		String username = (String) userSession.getUserProperties().get("username");
		if (username == null) {
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText(buildJsonData("System", "you are now connected as " + message));
			return;
		}
		Iterator<Session> iterator = sessionUsers.iterator();
		while (iterator.hasNext()) {
			iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
		}
	}

	@OnClose
	public void handleClose(Session userSession){
	sessionUsers.remove(userSession);
	}

	public String buildJsonData(String username,String message){
		Gson gson = new Gson();
		
		return gson.toJson(message);
	}
}


