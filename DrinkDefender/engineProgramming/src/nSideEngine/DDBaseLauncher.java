package nSideEngine;

import processing.core.PApplet;

public class DDBaseLauncher {
	public PApplet parent;
	
	public DDBaseLauncher(PApplet p)
	{
	    parent = p;
	}
	
	
	public DDGameManager gameManager;
	public void StartGame() {
		gameManager = new DDGameManager(parent);
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