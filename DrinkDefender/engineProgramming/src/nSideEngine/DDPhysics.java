package nSideEngine;
import processing.core.PApplet;
import processing.core.PVector;

public class DDPhysics extends DDGameComponent {
	
	int frameDelay = 2;
	private PVector velocity = new PVector(0,0);
	public DDBoxCollider boxCollider;
	float gravity = 0.2f;

	boolean isGrounded = false;
	public float speed = 3f;
	public float maxSpeed = 5f;
	
	public DDPhysics(DDGameObject g) 
	{
		super(g);
	}
	
	
	public void start() {
		this.boxCollider = new DDBoxCollider(this.gameObject);
		
	}
	
	public void update() {
		
		if (DDGameManager.frameCount % frameDelay == 0) {
			
		}
		
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		gravityEffect();
		if (PApplet.abs(velocity.x) >= maxSpeed) {
			if(velocity.x > 0)
				velocity.x = maxSpeed;
			else
				velocity.x = -maxSpeed;
		}
		if (isGrounded && PApplet.abs(velocity.x) <= 0.1f) {
			velocity.x = 0f;
		}
		this.transform.position.add(velocity);
		checkCollisions();
	}
	
	private void checkCollisions() {
		if(PApplet.abs(this.transform.prev_position.x - this.transform.position.x)<0.1f) {
			if(PApplet.abs(this.transform.prev_position.y - this.transform.position.y) <0.1f) {
				return;
			}
		}
	
	
	for (int i =0; i < DDGameManager.gameBoundingBoxes.size(); i++) {
		
		DDHitInfo hitInfo = new DDHitInfo();
		DDTransform t = DDGameManager.gameBoundingBoxes.get(i);
		hitInfo.boundingBox = t.NewWorldPcBoundingBox();
		
		if(t.ID == this.transform.ID) {
			continue;
		}
		hitInfo = this.boxCollider.checkCollision(hitInfo);
		if (hitInfo.didHit) {
			switch(hitInfo.hitSide) {
			case TOP:
				this.velocity.y = 0f;
				this.transform.position.y = hitInfo.boundingBox.top + this.transform.localBoundingBox.bottom;
				
				break;
			case BOTTOM:
				this.velocity.y = 0f;
				this.transform.position.y = hitInfo.boundingBox.top + this.transform.localBoundingBox.top;
				if(!isGrounded) {
					isGrounded = true;
					velocity.x = 0f;
				}
				PApplet.println("BOTTOM transform " + transform.ID + " velocity.x: " + velocity.x );
				break;
			case LEFT:
				this.velocity.x *= -1f;
				this.transform.position.x = hitInfo.boundingBox.left + this.transform.localBoundingBox.left;
				
				break;
			case RIGHT:
				this.velocity.x *= -1f;
				this.transform.position.x = hitInfo.boundingBox.right + this.transform.localBoundingBox.right;
				
				break;
			case NONE:
				isGrounded = false;
				break;
				}
			}
		}
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
	
	private void gravityEffect() {
		velocity.y += gravity;
		if (velocity.y >= maxSpeed)  {
			velocity.y = maxSpeed;
		}
	}
	public void setGravity(float g) {
		this.gravity = g;
	}
	

	
	



	

}
