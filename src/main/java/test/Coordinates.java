package test;

//import javax.json.*;

public class Coordinates {
	private int x;
	private int y;

	public Coordinates( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return String.format(
			"{" +
			"	\"x\" = %d," +
			"	\"y\" = %d," +
			"}",
			x, y);
	}
}
