package serverEndpoint;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import decoders.PaddleMoveDecoder;

import encoders.PaddleCreateEncoder;
import encoders.PaddleMoveEncoder;

import pong.Paddle;
import pong.PaddleMove;
import pong.PaddlePool;

@ServerEndpoint(
	value    = "/rectangle",
	decoders = {
		PaddleMoveDecoder.class,
	},
	encoders = {
		PaddleMoveEncoder.class,
		PaddleCreateEncoder.class,
	}
)
public class SocketServer {

	public SocketServer() { }

	@OnOpen
	public void open(Session session) throws IOException, EncodeException {
		System.out.println("socket connected");
		new ClientPool().add( session );

		Paddle paddle = new Paddle(session.getId());
		new PaddlePool().add( paddle );

		/*
		session.getBasicRemote().
			sendObject(
			   	paddle );
		*/

		// TODO these be errors

		session.getAsyncRemote().sendText( paddle.toString() );

		//session.getAsyncRemote().sendText( "{\"message\": \"Test message\"}" );
	}

	@OnClose
	public void close(Session session) {
		new ClientPool().remove( session );
		System.out.println("socket disconnected");
	}

	@OnMessage
	public void paddleMove(Paddle p) throws IOException, EncodeException {
		new ClientPool().sendToAll( new PaddleMove(p) );
	}	

	@OnMessage
	public void onMessage( String s ) {
		System.out.println( "Don't know what to do with data" );
		System.out.println( s );
	}

}
