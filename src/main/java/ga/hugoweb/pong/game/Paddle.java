package ga.hugoweb.pong.game;

import java.util.Random;

import org.json.JSONObject;

public class Paddle {
	private double xPos;
	private double yPos;
	private float width;
	private float height;

	private final String id;

	private String color;

	public Paddle( String id ) {
		this.xPos = 0;
		this.yPos = 0;

		this.width = 10;
		this.height = 30; 

		this.color = this.createColor();

		this.id = id;

		System.out.println( this.color );

	}


	private String createColor() {
		Random colorRand = new Random();
		String colorString = "#";
		for( int i = 0; i < 3; i++ )
			colorString = colorString.concat( String.format("%02X", colorRand.nextInt(256)) );

		return colorString;
	}

	/**
	 * @return the xPos
	 */
	public double getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the yPos
	 */
	public double getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	public JSONObject getJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("x", xPos);
		obj.put("y", yPos);
		obj.put("width", width);
		obj.put("height", height);
		obj.put("id", id);
		obj.put("color", color);

		return obj;
	}
}
