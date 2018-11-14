package nSideEngine;

public class BoxCollider extends ProcessingEntity {
	public BoundingBox boundingBox;
	public Transform transform = new Transform();
	public BoxCollider(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}
	
	public boolean checkCollision(BoundingBox tile_bb) {
		this.boundingBox = this.transform.WorldBoundingBox();
		if(tile_bb.left < this.boundingBox.right && tile_bb.right > this.boundingBox.left) {
			if(tile_bb.top < this.boundingBox.bottom) {
				this.transform.position.y = tile_bb.top - this.transform.boundingBox.bottom;
				return true;
			}
			if(tile_bb.bottom < this.boundingBox.top) {
				
			}
		}
		return false;
	}

}
