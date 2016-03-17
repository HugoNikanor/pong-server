package encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

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
	public String encode(Paddle object) throws EncodeException {
		// TODO Auto-generated method stub
		return null;
	}
}
