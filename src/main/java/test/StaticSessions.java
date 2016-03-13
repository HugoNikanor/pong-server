package test;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class StaticSessions {
	private static List<Session> sessions;

	public static void add( Session session ) {
		initiateList();
		sessions.add( session );
	}

	public static List<Session> getSessions() {
		initiateList();
		return sessions;
	}

	private static void initiateList() {
		if( sessions == null ) {
			sessions = new ArrayList<Session>();
		}
	}
}
