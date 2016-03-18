package ga.hugoweb.pong.serverEndpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Session;

public class ClientPool {
	private static Map<String, Session> sessions;


	public ClientPool() {
		initiateList();
	}

	public void add( Session session ) {
		sessions.put( session.getId(), session );
	}

	public void remove( Session session ) {
		sessions.remove( session.getId() );
	}

	/**
	 * Send a message to all clients,<br>
	 * Will probably fail if a proper encoder doesn't exist
	 */
	public void sendToAll(Object message) throws IOException, EncodeException {
		for( String str : sessions.keySet() ) {
			Session session = sessions.get(str);
			if( !session.isOpen() ) {
				sessions.remove( session );
			} else {
				sessions.get( str ).getBasicRemote().sendObject( message );
			}
		}
	}

	private void initiateList() {
		if( sessions == null ) {
			sessions = new HashMap<String, Session>();
		}
	}
}
