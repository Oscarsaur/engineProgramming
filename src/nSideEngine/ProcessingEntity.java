package nSideEngine;
import processing.core.PApplet;

public abstract class ProcessingEntity {
	public String Name;
	public int ID;
	public PApplet parent;
	
	public ProcessingEntity(PApplet p) {
		parent = p;
	}

}
