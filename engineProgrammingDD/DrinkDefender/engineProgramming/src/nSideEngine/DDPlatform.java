package nSideEngine;
import processing.core.PApplet;

public class DDPlatform extends DDSprite {
	
	public int strokeColour;
	public int fillColour;
	public int r;
	
	public DDPlatform(PApplet p, float x, float y, int w, int h, int r) {
		super(p, x, y);
		this.r = r;
		this.size.x = w;
		this.size.y = h;
		this.strokeColour = parent.color(120, 0, 255);
		this.fillColour = parent.color(0, 0, 0);
	}
	
	public void start() {
		super.start();
		this.transform.localBoundingBox.fromSize(size);
	}

	@Override
	public void update() {
		super.update();

	}
	
	public void render() {
		
		parent.pushMatrix();
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rotate(PApplet.radians(this.r));
		parent.rectMode(PApplet.CENTER);
		parent.rect(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
	}

}