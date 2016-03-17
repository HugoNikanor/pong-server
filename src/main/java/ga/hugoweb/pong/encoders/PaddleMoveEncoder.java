package ga.hugoweb.pong.encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.json.JSONObject;

import ga.hugoweb.pong.game.Paddle;
import ga.hugoweb.pong.game.PaddleMove;

public class PaddleMoveEncoder implements Encoder.Text<PaddleMove> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public String encode(PaddleMove pm) throws EncodeException {
		JSONObject paddleMove = new JSONObject();
		Paddle paddle = pm.getPaddle();
		paddleMove.put("x", paddle.getxPos());
		paddleMove.put("y", paddle.getyPos());
		paddleMove.put("id",paddle.getId());

		JSONObject obj = new JSONObject();
		obj.put("type", "paddle-move");
		obj.put("data", paddleMove );

		return obj.toString();
	}
}
