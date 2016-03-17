package pong;

import org.json.JSONObject;

public class Paddle {
	private double xPos;
	private double yPos;
	private float width;
	private float height;

	private String id;

	private String color;

	public Paddle( String id ) {
		this.xPos = 0;
		this.yPos = 0;

		this.width = 10;
		this.height = 30; 

		this.color = "#0000FF";

		this.id = id;
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
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
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
