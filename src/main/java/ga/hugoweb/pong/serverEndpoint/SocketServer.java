package ga.hugoweb.pong.serverEndpoint;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

import ga.hugoweb.pong.decoders.PaddleMoveDecoder;
import ga.hugoweb.pong.encoders.JSONObjectEncoder;
import ga.hugoweb.pong.encoders.PaddleCreateEncoder;
import ga.hugoweb.pong.encoders.PaddleMoveEncoder;
import ga.hugoweb.pong.game.Paddle;
import ga.hugoweb.pong.game.PaddleMove;
import ga.hugoweb.pong.game.PaddlePool;

@ServerEndpoint(
	value    = "/rectangle",
	decoders = {
		PaddleMoveDecoder.class,
	},
	encoders = {
		PaddleMoveEncoder.class,
		PaddleCreateEncoder.class,
		JSONObjectEncoder.class,
	}
)
public class SocketServer {

	public SocketServer() { }

	@OnOpen
	public void open(Session session) throws IOException, EncodeException {

		JSONObject obj = new JSONObject();
		obj.put("type", "own-identifier");
		obj.put("data", session.getId());
		session.getAsyncRemote().sendText( obj.toString() );

		ClientPool cp = new ClientPool();
		cp.add( session );

		Paddle paddle = new Paddle(session.getId());
		PaddlePool pp = new PaddlePool();
		pp.put( paddle );
		
		// send data that this is the paddle to control

		for( String s : pp.getKeys() ) {
			cp.sendToAll( pp.get(s) );
		}

		System.out.println("session INITIATED [" + session.getId() + "]");
	}

	@OnClose
	public void close(Session session) throws IOException, EncodeException {
		ClientPool cp = new ClientPool();
		cp.remove( session );

		PaddlePool pp = new PaddlePool();
		pp.remove( session.getId() );

		JSONObject jobj = new JSONObject();
		jobj.put("type", "client-disconnect");
		jobj.put("data", session.getId());
		System.out.println( jobj );
		cp.sendToAll( jobj );

		System.out.println("session CLOSED [" + session.getId() + "]");
	}

	@OnMessage
	public void paddleMove(PaddleMove p, Session session) throws IOException, EncodeException {

		Paddle paddle = p.getPaddle();
		new PaddlePool().put( paddle );
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
