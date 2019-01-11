package nSideEngine;
import processing.core.*;

public abstract class DDSprite extends DDGameObject {
	public PVector size = new PVector(12,12);
	public DDSprite(PApplet p) {
		super(p);
	}
	public DDSprite(PApplet p, float x, float y) {
		super(p);
		this.transform.position.x = x;
		this.transform.position.y = y;
		
	}
	
	public abstract void render();
	
	public void update() {
		for(int i = this.components.size() - 1; i>= 0; i--) {
			DDGameComponent comp = this.components.get(i);
			comp.update();
			comp.render();
		}
	}
	
	public void start() {
		for(int i = this.components.size() - 1; i >= 0; i--) {
			DDGameComponent comp = this.components.get(i);
			comp.start();
		}
	}

}
