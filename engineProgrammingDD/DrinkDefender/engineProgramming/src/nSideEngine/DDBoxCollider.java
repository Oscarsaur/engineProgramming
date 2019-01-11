package nSideEngine;

public class DDBoxCollider extends DDProcessingEntity {
	
	
	public DDTransform transform = new DDTransform();
	
	
	public DDBoxCollider(DDGameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}
	
	public DDHitInfo checkCollision(DDHitInfo hitInfo) {
		DDBoundingBox new_bb;
		new_bb = this.transform.NewWorldPcBoundingBox();
		DDBoundingBox prev_bb;
		prev_bb = this.transform.PreviousWorldPcBoundingBox();
		DDBoundingBox tile_bb = hitInfo.boundingBox;
		if(this.transform.position.y > tile_bb.top && this.transform.position.y < tile_bb.bottom) {
			
			if(new_bb.left < tile_bb.right && new_bb.right > tile_bb.right) {
				hitInfo.hitSide = DDSIDES.RIGHT;
				hitInfo.didHit = true;
			}
			if(new_bb.left < tile_bb.left && new_bb.right > tile_bb.left) {
				hitInfo.hitSide = DDSIDES.LEFT;
				hitInfo.didHit = true;
			}
		}
		if (new_bb.right > tile_bb.left && new_bb.left < tile_bb.right) {
			if(new_bb.bottom > tile_bb.top && prev_bb.top < tile_bb.top) {
				hitInfo.hitSide = DDSIDES.BOTTOM;
				hitInfo.didHit = true;
			}
			if(new_bb.top < tile_bb.bottom && prev_bb.bottom > tile_bb.bottom) {
				hitInfo.hitSide = DDSIDES.TOP;
				hitInfo.didHit = true;
			}
		
		}else {
			
		}
		return hitInfo;
		
	}
	
}
