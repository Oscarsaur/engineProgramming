package nSideEngine;
import processing.core.PVector;

public class Physics extends GameComponent {
	private PVector velocity = new PVector(0,0);
	float gravity = 0.1f;
	//boolean canJump = true;
	
	public Physics(GameObject g) 
	{
		super(g);
	}
	
	
	public void start() {
		
	}
	
	public void update() {
		gravityEffect();
		this.transform.position.y += velocity.y;
	}
	
	public void isGrounded() {
		//Waiting for canJump = true stuff
	}
	
	private void gravityEffect() {
		velocity.y += gravity;
		if (velocity.y >= 4f) {
			velocity.y = 4f;
		}
	}


	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
