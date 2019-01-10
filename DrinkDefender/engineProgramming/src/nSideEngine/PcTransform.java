package nSideEngine;

import processing.core.PVector;

public class PcTransform {
	
	public PcTransform() {
		
	}
	public PVector prev_position = new PVector(0,0);
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);
	public PcBoundingBox localBoundingBox = new PcBoundingBox(-1,1,-1,1);
	public PcBoundingBox worldBoundingBox = new PcBoundingBox(-1,1,-1,1);
	
	public PcBoundingBox PreviousWorldPcBoundingBox() {
		PcBoundingBox bb = new PcBoundingBox();
		bb.center_x = prev_position.x;
		bb.center_y = prev_position.y;
		bb.left = prev_position.x + localBoundingBox.left;
		bb.right = prev_position.x + localBoundingBox.right;
		bb.top = prev_position.y + localBoundingBox.top;
		bb.bottom = prev_position.y + localBoundingBox.bottom;
		return bb;
	}
	
	public PcBoundingBox NewWorldPcBoundingBox() {
		this.worldBoundingBox = new PcBoundingBox();
		this.worldBoundingBox.center_x = position.x;
		this.worldBoundingBox.center_y = position.y;
		this.worldBoundingBox.left = position.x + localBoundingBox.left;
		this.worldBoundingBox.right = position.x + localBoundingBox.right;
		this.worldBoundingBox.top = position.y + localBoundingBox.top;
		this.worldBoundingBox.bottom = position.y + localBoundingBox.bottom;
		return this.worldBoundingBox;
	}

}
