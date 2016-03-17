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
		System.out.println("session initiated: " + session.getId());

		ClientPool cp = new ClientPool();
		cp.add( session );

		Paddle paddle = new Paddle(session.getId());
		new PaddlePool().add( paddle );

		cp.sendToAll( paddle );

	}

	@OnClose
	public void close(Session session) {
		new ClientPool().remove( session );
		PaddlePool pp = new PaddlePool();
		pp.remove( pp.get( session.getId() ) );

		System.out.println("session closed: " + session.getId());
	}

	@OnMessage
	public void paddleMove(PaddleMove p, Session session) throws IOException, EncodeException {

		Paddle paddle = p.getPaddle();
		new PaddlePool().add( paddle );
		new ClientPool().sendToAll( p );
	}

	/*
	@OnMessage
	public void onMessage( String s ) {
		System.out.println( "Don't know what to do with data" );
		System.out.println( s );
	}
	*/
}
