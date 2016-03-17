package ga.hugoweb.pong.decoders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.json.JSONObject;

import ga.hugoweb.pong.game.Paddle;
import ga.hugoweb.pong.game.PaddleMove;
import ga.hugoweb.pong.game.PaddlePool;

public class PaddleMoveDecoder implements Decoder.Text<PaddleMove> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		System.out.println( "paddle-move decoder init" );

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println( "paddle-move decoder destroy" );

	}

	@Override
	public PaddleMove decode(String s) throws DecodeException {
		System.out.println( s );

		JSONObject obj = new JSONObject( s );
		JSONObject jsonPaddle = obj.getJSONObject("data");
		Paddle paddle = new PaddlePool().get( jsonPaddle.getString("id") );

		paddle.setxPos( jsonPaddle.getDouble("x") );
		paddle.setyPos( jsonPaddle.getDouble("y") );

		return new PaddleMove(paddle);
	}

	@Override
	public boolean willDecode(String s) {
		System.out.println( "paddle-move-decoder accessed" );
		JSONObject obj = new JSONObject( s );
		return obj.getString("type").equals("paddle-move")
			? true
			: false;
	}
}
