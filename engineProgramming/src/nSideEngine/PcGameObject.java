package nSideEngine;
import java.util.ArrayList;

import processing.core.*;

public abstract class PcGameObject extends PcProcessingEntity {
	public PcGameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<PcGameComponent>();
	}
	
	public String name;
	public String tag;
	
	public ArrayList<PcGameComponent> components;
	public PcTransform transform = new PcTransform();
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
