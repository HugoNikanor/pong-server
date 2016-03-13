package test;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class SocketServer {

	public SocketServer() { }


	@OnOpen
	public void open(Session session) {
		System.out.println("socket connected");
		StaticSessions.add( session );
	}

	@OnClose
	public void close(Session session) {
		System.out.println("socket disconnected");
	}

	@OnMessage
	public void onMessage( String message ) {
		/*
		if( message.equals( "Can I have a response?" ) ) {
			return "<Server> No";
		}
		return "<Server> Default response ";
		*/
		for( Session s : StaticSessions.getSessions() ) {
			if( !s.isOpen() ) {
				StaticSessions.remove( s );
				continue;
			}

			System.out.println( "client" );
			try {
				s.getBasicRemote().sendText( message );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(
		"————————————————————————————————————————————————————————————————————————————————"
		);
	}

}
