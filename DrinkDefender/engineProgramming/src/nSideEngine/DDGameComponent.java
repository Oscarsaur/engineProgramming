package nSideEngine;

public abstract class DDGameComponent extends DDProcessingEntity{
	public DDGameComponent(DDGameObject g) {
		super(g.parent);
		
		this.gameObject = g;
		this.transform = this.gameObject.transform;
		this.gameObject.components.add(this);
	}
	public DDGameObject gameObject;
	public DDTransform transform;
	public abstract void start();
	public abstract void update();
	public abstract void render();

}
