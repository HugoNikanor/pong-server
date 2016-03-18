package ga.hugoweb.pong.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PaddlePool {
	private static Map<String, Paddle> paddles;

	public PaddlePool() {
		setUpMap();
	}

	public Paddle get( String id ) {
		setUpMap();
		return paddles.get( id );
	}

	public void remove( String id ) {
		paddles.remove( id );
	}

	public void put( Paddle paddle ) {
		paddles.put( paddle.getId(), paddle );

	}

	public Set<String> getKeys() {
		return paddles.keySet();
	}

	private void setUpMap() {
		if( paddles == null ) {
			paddles = new HashMap<String, Paddle>();
		}
	}
}
