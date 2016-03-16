package test;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
		Coordinates coords = null;
		System.out.println( s );
		System.out.println( "decoding..." );

		coords = new Coordinates( 5, 5 );

		//JsonReader reader = Json.createReader( new StringReader(s));
		//JsonObject jobj = reader.readObject();
		//reader.close();

		//return new Coordinates( jobj.getInt("x"),
		//                        jobj.getInt("y") );
		//return new Coordinates( 5, 5 );
		return coords;
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		System.out.println( "willDecode accessed" );
		return true;
	}
}
