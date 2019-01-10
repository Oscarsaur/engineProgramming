import PurpCube.PcLauncher;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");
	}
	PcLauncher launcher;
	public void setup() {
		background(0);
		launcher = new PcLauncher(this);
		launcher.StartGame();

	}
	
	public void draw() {
		launcher.StartGame();
		if(launcher.started)
			launcher.UpdateAll();
	}

	public void settings() {
		size(640,480);
	}
	
	public void keyPressed() {
		launcher.keyPressed(key, keyCode);
	}
	public void keyReleased() {
		launcher.keyPressed(key, keyCode);
	}
}
