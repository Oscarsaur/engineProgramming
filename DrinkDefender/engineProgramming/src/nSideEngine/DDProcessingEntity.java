package nSideEngine;
import processing.core.PApplet;

public abstract class DDProcessingEntity {
	public String Name;
	public int ID;
	public PApplet parent;
	
	public DDProcessingEntity(PApplet p) {
		parent = p;
	}

}
