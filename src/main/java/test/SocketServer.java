package test;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class SocketServer {

	@OnOpen
	public void open(Session session) {
		System.out.println("socket connected");
	}

	@OnClose
	public void close(Session session) {
		System.out.println("socket disconnected");
	}

	@OnMessage
	public String onMessage( String message, Session session ) {
		if( message.equals( "Can I have a response?" ) ) {
			return "<Server> No";
		}
		return "<Server> Default response ";
	}

}
