package PurpCube;
import nSideEngine.Physics;
import nSideEngine.Sprite;
import processing.core.PApplet;
import processing.core.PVector;

public class Player extends Sprite {
	//float speed = 3f;
	float gravity = 0.1f;
	public PVector size = new PVector(12,12);
	private Physics physics;
	public int stroke = parent.color(120,0,255);
	public int fill = parent.color(120,0,255);
	
	public Player(PApplet p) {
		super(p);
	}
	
	public Player(PApplet p, float x, float y, float w, float h) {
		super(p);
		//speed = 3.0f;
	}
	
	public void start() {
		this.transform.position.x = parent.width / 2;
		this.transform.position.y = parent.height / 2;
		this.physics = new Physics(this);
		this.physics.start();
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
	public void render() {
		super.render();
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	}

}
