package ga.hugoweb.pong.game;

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
