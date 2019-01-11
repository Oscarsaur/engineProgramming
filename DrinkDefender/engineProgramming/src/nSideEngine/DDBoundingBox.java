package nSideEngine;
import processing.core.PVector;
public class DDBoundingBox {
	public DDBoundingBox(DDTransform _transform) {
		
	}
	public DDTransform transform;
	public DDBoundingBox(DDTransform _transform, int _l, int _r, int _t, int _b, int _rot) {
		this.transform = _transform;
		this.rotation = _rot;
		this.left = _l;
		this.right = _r;
		this.top = _t;
		this.bottom = _b;
		this.center_x = 0;
		this.center_y = 0;
		
	}
	public void fromSize(DDTransform _transform, PVector size) {
		this.transform = _transform;
		this.left = -size.x/2f;
		this.right = size.x/2f;
		this.top = -size.y/2f;
		this.bottom = size.y/2f;
		this.center_x = 0;
		this.center_y = 0;
	}
	public float center_x;
	public float center_y;
	public float left;
	public float right;
	public float top;
	public float bottom;
	public float rotation;
	

}
