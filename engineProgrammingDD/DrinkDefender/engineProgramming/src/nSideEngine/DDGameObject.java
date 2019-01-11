package nSideEngine;
import java.util.ArrayList;

import processing.core.*;

public abstract class DDGameObject extends DDProcessingEntity {
	public DDGameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<DDGameComponent>();
	}
	
	public String name;
	public String tag;
	
	public ArrayList<DDGameComponent> components;
	public DDTransform transform = new DDTransform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	//public void checkCollisions( PcBoundingBox bb) {}
	public void keyPressed(char key, int keyCode) {}
	public void keyReleased(char key, int keyCode) {}
	
	public String ToString() {
		return this.name;
	}


}
