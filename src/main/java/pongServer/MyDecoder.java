package pongServer;

import org.json.*;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MyDecoder implements Decoder.Text<Coordinates> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public Coordinates decode(String s) throws DecodeException {
		System.out.println( s );

		JSONObject jobj = new JSONObject( s );

		return new Coordinates( jobj.getInt("x"),
		                        jobj.getInt("y") );
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		System.out.println( "willDecode accessed" );
		return true;
	}
}
