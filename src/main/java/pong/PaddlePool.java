package pong;

import java.util.HashMap;
import java.util.Map;

public class PaddlePool {
	private static Map<String, Paddle> paddles;

	public PaddlePool() {
		setUpMap();
	}

	public Paddle get( String id ) {
		setUpMap();
		return paddles.get( id );
	}

	public void remove( Paddle paddle ) {
		paddles.remove( paddle );
	}

	public void add( Paddle paddle ) {
		paddles.put( paddle.getId(), paddle );
	}

	private void setUpMap() {
		if( paddles == null ) {
			paddles = new HashMap<String, Paddle>();
		}
	}
}