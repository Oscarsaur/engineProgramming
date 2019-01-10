package nSideEngine;
import processing.core.PApplet;
import processing.core.PVector;

public class PcPhysics extends PcGameComponent {
	
	int frameDelay = 2;
	private PVector velocity = new PVector(0,0);
	public PcBoxCollider boxCollider;
	float gravity = 0.2f;
	float friction = 0.9f;
	float frictionOveride = 1.0f;
	float frictionNormal = 0.9f;
	boolean isGrounded = true;
	public float speed = 3f;
	public float maxSpeed = 5f;
	//boolean canJump = true;
	
	public PcPhysics(PcGameObject g) 
	{
		super(g);
	}
	
	
	public void start() {
		this.boxCollider = new PcBoxCollider(this.gameObject);
		
	}
	
	public void update() {
		
		if (PcGameManager.frameCount % frameDelay == 0) {
			
		}
		
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		gravityEffect();
		if(isGrounded) {
			this.velocity.x *= friction;
		}
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
	
	
	for (int i =0; i < PcGameManager.gameBoundingBoxes.size(); i++) {
		
		PcHitInfo hitInfo = new PcHitInfo();
		hitInfo.boundingBox = PcGameManager.gameBoundingBoxes.get(i);
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

	public void jump(float force) {
		if(isGrounded) {
			velocity.y = -force;
			isGrounded = false;
		}
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
	
	public void move(float force) {
		if(isGrounded) {
			this.friction = this.frictionOveride;
			velocity.x += force;
		}
	}
	
	public void keyUp() {
		if(isGrounded) {
			this.friction = this.frictionNormal;
		}
	}
	
	



	

}
