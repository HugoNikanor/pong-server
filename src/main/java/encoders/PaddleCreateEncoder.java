package encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.json.JSONObject;

import pong.Paddle;

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
		JSONObject jsonPaddle = new JSONObject();
		jsonPaddle.put("x", paddle.getxPos());
		jsonPaddle.put("y", paddle.getyPos());
		jsonPaddle.put("width", paddle.getWidth());
		jsonPaddle.put("height", paddle.getHeight());
		jsonPaddle.put("color", paddle.getColor());
		jsonPaddle.put("id",paddle.getId());

		JSONObject obj = new JSONObject();
		obj.put("type", "paddle-create");
		obj.put("data", jsonPaddle );

		return obj.toString();
	}
}
