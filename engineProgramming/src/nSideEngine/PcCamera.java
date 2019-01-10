package nSideEngine;

import processing.core.PApplet;
import processing.core.PVector;

public class PcCamera extends PcGameObject{
	public PcGameObject followMe;
	public float offsetLimit = 100;
	public PVector cameraOffset = new PVector(0,0);
	public PcCamera(PApplet p, PcGameObject f) {
		super(p);
		this.followMe = f;
		
	}
	public PcCamera(PApplet p, PcGameObject f, float limit) {
		super(p);
		this.followMe = f;
		offsetLimit = limit;
		
	}
	

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		late_update_xy();
	}
	
	private void late_update_xy() {
		PVector virtualScreenCentre = PcGameManager.screenOffset.copy();
		virtualScreenCentre.add(PcGameManager.offset);
		PVector virtualPlayer = PcGameManager.offset.copy();
		virtualPlayer.add(this.followMe.transform.position);
		float d = virtualScreenCentre.dist(virtualPlayer);
		
		if (d > offsetLimit) {
			virtualScreenCentre.sub(virtualPlayer);
			virtualScreenCentre.add(this.cameraOffset);
			PcGameManager.offset.lerp(virtualScreenCentre, 0.02f);
		}
	}

}
