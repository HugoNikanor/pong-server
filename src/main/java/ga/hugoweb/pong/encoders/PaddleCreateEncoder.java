package ga.hugoweb.pong.encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.json.JSONObject;

import ga.hugoweb.pong.game.Paddle;

public class PaddleCreateEncoder implements Encoder.Text<Paddle> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public String encode(Paddle paddle) throws EncodeException {
		JSONObject obj = new JSONObject();
		obj.put("type", "paddle-create");
		obj.put("data", paddle.getJSONObject() );

		return obj.toString();
	}
}
