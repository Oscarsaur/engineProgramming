package dRink;

import nSideEngine.DDSprite;
import processing.core.PApplet;

public class DDHandCursor extends DDSprite {

	public DDHandCursor(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public DDHandCursor(PApplet p, float x, float y) {
		super(p, x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update() {
		this.transform.position.x = parent.mouseX;
		this.transform.position.y = parent.mouseY;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		parent.pushMatrix();
		parent.translate(this.transform.position.x, this.transform.position.y);
		parent.rect(0, 0, 50, 50);
		
		parent.popMatrix();

	}

}
