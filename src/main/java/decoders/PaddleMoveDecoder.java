package decoders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.json.JSONObject;

import pong.Paddle;
import pong.PaddlePool;

public class PaddleMoveDecoder implements Decoder.Text<Paddle> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public Paddle decode(String s) throws DecodeException {
		JSONObject obj = new JSONObject( s );
		JSONObject jsonPaddle = obj.getJSONObject("data");
		Paddle paddle = new PaddlePool().get( jsonPaddle.getString("id") );

		paddle.setxPos( jsonPaddle.getDouble("x") );
		paddle.setyPos( jsonPaddle.getDouble("y") );

		return paddle;
	}

	@Override
	public boolean willDecode(String s) {
		JSONObject obj = new JSONObject( s );
		return obj.getString("type").equals("paddle-move")
			? true
			: false;
	}
}
