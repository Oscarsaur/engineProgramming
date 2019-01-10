package PurpCube;
import nSideEngine.PcPhysics;
import nSideEngine.PcSprite;
import processing.core.PApplet;
import processing.core.PVector;

public class PcPlayer extends PcSprite {
	float speedForce = 3f;
	float jumpForce = 10f;
	public PVector size = new PVector(12,12);
	private PcPhysics physics;
	public int stroke = parent.color(120,0,255);
	public int fill = parent.color(120,0,255);
	
	public PcPlayer(PApplet p) {
		super(p);
	}
	
	public PcPlayer(PApplet p, float x, float y, float w, float h) {
		super(p);
	}
	
	public void start() {
		this.transform.position.x = parent.width / 2;
		this.transform.position.y = parent.height / 2;
		this.transform.localBoundingBox.fromSize(size);
		this.physics = new PcPhysics(this);
		this.physics.start();
		this.physics.speed = speedForce;
	}

//	public void checkCollisions(BoundingBox bb) {
//	this.physics.checkCollisions(bb);
//}
	
	@Override
	public void update() {
		super.update();

	}
	
	public void render() {
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	}
	
	public void keyPressed(char key, int keyCode) {
		if(keyCode == PApplet.UP) {
			this.physics.jump(4);
		}
		if (keyCode == PApplet.LEFT) {
			this.physics.move(-speedForce);
		}
		if (keyCode == PApplet.RIGHT) {
			this.physics.move(speedForce);
		}
		
		
	}
	
	public void keyReleased(char key, int keyCode) {
		this.physics.keyUp();
	}

}
