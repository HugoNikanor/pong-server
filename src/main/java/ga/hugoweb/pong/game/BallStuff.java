package ga.hugoweb.pong.game;

import java.io.IOException;

import javax.websocket.EncodeException;

import ga.hugoweb.pong.serverEndpoint.ClientPool;

public class BallStuff {

	private static Paddle ball;

	public BallStuff() {
		if( ball == null ) {
			ball = new Paddle( "totaly-not-a-paddle" );
			ball.setWidth(20);
			ball.setHeight(20);
			new Thread(new BallThread()).start();
		}
	}

	public boolean isInitiated() {
		return (ball != null);
	}

	/**
	 * @return the ball
	 */
	public Paddle getBall() {
		return ball;
	}

	private class BallThread implements Runnable {

		@Override
		public void run() {
			synchronized( this ) {
				while( true ) {
					ball.setxPos( ball.getxPos() + 3 );

					try {
						new ClientPool().sendToAll(new PaddleMove(ball));
						this.wait( 2500 );
					} catch (IOException | EncodeException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}
}
