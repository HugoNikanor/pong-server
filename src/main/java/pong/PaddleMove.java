package pong;

public class PaddleMove {
	private Paddle paddle;
	public PaddleMove( Paddle paddle ) {
		this.paddle = paddle;
	}

	/**
	 * @return the paddle
	 */
	public Paddle getPaddle() {
		return paddle;
	}

}
