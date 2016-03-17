package pongServer;

import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
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

		//StringReader strReader = new StringReader( s );
		StringReader strReader = new StringReader( "{x:5,y:6}\n" );
		System.out.println( "strReader created" ); 

		//ByteArrayInputStream inStream = new ByteArrayInputStream( s.getBytes() );
		//System.out.println( "inStream created" );


		// Here is the problem
		JsonReaderFactory factory = javax.json.Json.createReaderFactory( null );
		System.out.println( "factoryCreated" );

		//System.out.println("something");
		JsonReader reader = javax.json.Json.createReader( strReader );
		////JsonReader reader = factory.createReader( inStream );
		System.out.println( "reader loaded"  );

		//JsonObject jobj = reader.readObject();
		//System.out.println( "jobj created" );

		//reader.close();
		//System.out.println("fixed");

		//return new Coordinates( jobj.getInt("x"),
		//                        jobj.getInt("y") );
		return new Coordinates( 5, 6 );
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		System.out.println( "willDecode accessed" );
		return true;
	}
}
