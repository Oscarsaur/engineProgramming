package nSideEngine;
import processing.core.PApplet;

public abstract class PcProcessingEntity {
	public String Name;
	public int ID;
	public PApplet parent;
	
	public PcProcessingEntity(PApplet p) {
		parent = p;
	}

}
