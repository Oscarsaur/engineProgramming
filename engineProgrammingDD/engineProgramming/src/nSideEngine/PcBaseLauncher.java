package nSideEngine;

import processing.core.PApplet;

public class PcBaseLauncher {
	public PApplet parent;
	
	public PcBaseLauncher(PApplet p)
	{
	    parent = p;
	}
	
	
	public PcGameManager gameManager;
	public void StartGame() {
		gameManager = new PcGameManager(parent);
	}
	public void UpdateAll() {
		gameManager.UpdateAll();
	}
	
	public void keyPressed(char key, int keyCode) {
		gameManager.keyPressed(key, keyCode);
	}
	
	public void keyReleased(char key, int keyCode) {
		gameManager.keyReleased(key, keyCode);
	}

}