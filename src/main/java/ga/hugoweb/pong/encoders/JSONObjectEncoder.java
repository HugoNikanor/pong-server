package ga.hugoweb.pong.encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.json.JSONObject;

public class JSONObjectEncoder implements Encoder.Text<JSONObject> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public String encode(JSONObject object) throws EncodeException {
		String str = object.toString();
		System.out.println( str );
		return str;
	}

}
