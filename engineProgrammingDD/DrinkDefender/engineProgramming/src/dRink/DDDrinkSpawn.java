package dRink;
import nSideEngine.DDPhysics;
import nSideEngine.DDSprite;
import processing.core.PApplet;

public class DDDrinkSpawn extends DDSprite {
	private DDPhysics physics;
	public int stroke = parent.color(120,0,255);
	public int fill = parent.color(120,0,255);
	
	public DDDrinkSpawn(PApplet p) {
		super(p);
	}
	
	public DDDrinkSpawn(PApplet p, float x, float y, float w, float h) {
		super(p);
	}
	
	public void start() {
		this.transform.position.x = parent.random(0 + parent.width / 3, parent.width - parent.width / 3);
		this.transform.position.y = (parent.height/8);
		this.transform.localBoundingBox.fromSize(size);
		this.physics = new DDPhysics(this);
		this.physics.start();
	}


	
	@Override
	public void update() {
		super.update();

	}
	
	public void render() {
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.ellipse(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	}
	
	
		
		
	

	public void keyReleased(char key, int keyCode) {
		this.physics.keyUp();
	}

}
