package dRink;
import nSideEngine.DDPhysics;
import nSideEngine.DDSprite;
import processing.core.PApplet;

public class DDDrinkSpawn extends DDSprite {
	private DDPhysics physics;
	public int stroke = parent.color(120,0,255);
	public int fill = parent.color(120,0,255);
	int waiting = 0;
	DDLauncher launcher;
	public DDDrinkSpawn(PApplet p) {
		super(p);
		this.start();
	}
	
	public DDDrinkSpawn(PApplet p, float x, float y, float w, float h) {
		super(p);
		this.start();
	}
	public DDDrinkSpawn(PApplet p, DDLauncher l, float x, float y, float w, float h) {
		super(p);
		this.launcher = l;
		this.start();
	}
	public void start() {
		this.transform.position.x = parent.random(0 + parent.width / 3, parent.width - parent.width / 3);
		this.transform.position.y = (0);
		this.transform.localBoundingBox.fromSize(this.transform, size);
		this.physics = new DDPhysics(this);
		this.physics.start();
	}


	
	@Override
	public void update() {
		super.update();
//this.launcher
		 if (this.transform.position.y < 150) {
	        	waiting++;
	        	if (waiting > 150) {
	        		this.launcher.drinksFilled += 1;
	        		this.launcher.ReLoad();
	        		
	        	}
	        	
	        }
		 if (this.transform.position.y < 90 && this.transform.position.y > 60) {
			 waiting++;
	        	if (waiting > 90) {
	        		this.launcher.drinksOverFilled += 1;
	        		this.launcher.ReLoad();
	        	}
		 }
	}
	
	public void render() {
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.ellipse(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	}
	
	
		
		
	


}
