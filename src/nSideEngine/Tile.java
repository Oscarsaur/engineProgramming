package nSideEngine;
import processing.core.PApplet;

public class Tile extends Sprite {
	
	public int width;
	public int height;
	int strokeColour;
	int fillColour;
	
	public Tile(PApplet p, int x, int y, int w, int h) {
		super(p, x, y);
		this.width = w;
		this.height = h;
		this.strokeColour = parent.color(120, 0, 255);
		this.fillColour = parent.color(0, 0, 0);
	}
	
	public void start() {
		super.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
	public void render() {
		super.render();
		parent.pushMatrix();
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rect(0, 0, this.width, this.height);
		parent.popMatrix();
	}

}
