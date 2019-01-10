package nSideEngine;

public abstract class PcGameComponent extends PcProcessingEntity{
	public PcGameComponent(PcGameObject g) {
		super(g.parent);
		
		this.gameObject = g;
		this.transform = this.gameObject.transform;
		this.gameObject.components.add(this);
	}
	public PcGameObject gameObject;
	public PcTransform transform;
	public abstract void start();
	public abstract void update();
	public abstract void render();

}
