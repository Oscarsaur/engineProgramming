package nSideEngine;

public class PcBoxCollider extends PcProcessingEntity {
	
	
	public PcTransform transform = new PcTransform();
	
	
	public PcBoxCollider(PcGameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}
	
	public PcHitInfo checkCollision(PcHitInfo hitInfo) {
		PcBoundingBox new_bb;
		new_bb = this.transform.NewWorldPcBoundingBox();
		PcBoundingBox prev_bb;
		prev_bb = this.transform.PreviousWorldPcBoundingBox();
		PcBoundingBox tile_bb = hitInfo.boundingBox;
		if(this.transform.position.y > tile_bb.top && this.transform.position.y < tile_bb.bottom) {
			
			if(new_bb.left < tile_bb.right && new_bb.right > tile_bb.right) {
				hitInfo.hitSide = PcSIDES.RIGHT;
				hitInfo.didHit = true;
			}
			if(new_bb.left < tile_bb.left && new_bb.right > tile_bb.left) {
				hitInfo.hitSide = PcSIDES.LEFT;
				hitInfo.didHit = true;
			}
		}
		if (new_bb.right > tile_bb.left && new_bb.left < tile_bb.right) {
			if(new_bb.bottom > tile_bb.top && prev_bb.top < tile_bb.top) {
				hitInfo.hitSide = PcSIDES.BOTTOM;
				hitInfo.didHit = true;
			}
			if(new_bb.top < tile_bb.bottom && prev_bb.bottom > tile_bb.bottom) {
				hitInfo.hitSide = PcSIDES.TOP;
				hitInfo.didHit = true;
			}
		
		}else {
			
		}
		return hitInfo;
		
	}
	
}
