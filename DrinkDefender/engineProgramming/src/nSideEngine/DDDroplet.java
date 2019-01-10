package nSideEngine;

import processing.core.PApplet;

public class DDDroplet extends PcSprite {
	
	public int strokeColour;
	public int fillColour;
		  public float px, py;
		  public float vx, vy;
		  public float h, w;
		  public float gravity = 0.1f;
		  public float terminalSpeed = 5.2f;
		  private float bounce = -0.02f;
		  private float decay = 0.95f;
		  private boolean moving = true;
		  public DDDroplet(PApplet p, float px, float py,float w, float h){
			super(p, px, py);
		    this.px = px;
		    this.py = py;
		    this.w = w;
		    this.h = h;
		    this.vy = 0.1f;
		    this.vx = 0f;
		  }
			public void start() {
				super.start();
				this.transform.localBoundingBox.fromSize(size);
			}

			@Override
			public void update() {
				super.update();

			}
			
			public void render() {
				
				parent.pushMatrix();
				parent.translate(this.transform.position.x, this.transform.position.y);
				parent.stroke(this.strokeColour);
				parent.fill(this.fillColour);
				parent.ellipseMode(PApplet.CENTER);
				parent.ellipse(0, 0, this.size.x, this.size.y);
				parent.popMatrix();
			}
		  private void Gravity(){
		    this.vy += this.gravity;
		    if(this.vy > terminalSpeed){
		      this.vy = terminalSpeed;
		    }
		  }
		   public void checkCollision(DDPlatform platform)
		  {
		    float hit_y = this.py;//  + this.h / 2;
		    float hit_left = this.px + this.w / 8;
		    float hit_right = this.px - this.w / 8;
		 
		 
		 //rotation of plat form
		     float tx = this.px - platform.px;
		     float platform_ty = tx * tan(radians(platform.r)) + platform.py + 0.001f;

		     
		     if(PApplet.abs(bounce) < 0.0001){
		      moving = false;
		    }
		     if(moving && hit_y >= platform_ty){
		    
		        if(hit_left > platform.left && hit_right < platform.right){
		           this.vy *= bounce;
		           this.vx = this.vy * sin(radians(-platform.r));
		          
		           bounce *= decay;
		           //change vx
		          
		           
		        }
		      }
		  }
		

	public DDDroplet(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public DDDroplet(PApplet p, float x, float y) {
		super(p, x, y);
		// TODO Auto-generated constructor stub
	}




}
