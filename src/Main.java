import PurpCube.Launcher;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");
	}
	Launcher launcher;
	public void setup() {
		background(0);
		launcher = new Launcher(this);
		launcher.StartGame();

	}
	
	public void draw() {
		launcher.UpdateAll();
	}

	public void settings() {
		size(1440,900);
	}
}
