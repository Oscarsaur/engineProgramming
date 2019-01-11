package dRink;

import nSideEngine.*;
import processing.core.PApplet;


public class DDLauncher extends DDBaseLauncher{
	public boolean started = false;
	int waiting = 0;

	public DDLauncher(PApplet p) {
		super(p);
	}
	
	public void keyPressed(char key, int keyCode) {
		super.keyPressed(key, keyCode);
		if (key == 'b' || key == 'B') {
			this.ReLoad();
			
		}
			
		if (key == 'p' || key == 'P') {
			this.liquidSpawn();
				
			
		}
	}
	
	
	
	

	public void keyReleased(char key, int keyCode) {
		super.keyReleased(key, keyCode);
	}
	
	private void liquidSpawn() {
		DDDrinkSpawn player = new DDDrinkSpawn(parent, parent.width/2,parent.height/2,60, 60);
        player.start();
        this.gameManager.addObject(player);
        this.gameManager.addPlayerGameObjects(player);
        
		
	}
	
	public void ReLoad() {
		this.gameManager.Init();
		TestRestart();
	}

	public void StartGame(){
		if (this.started)
			return;
		super.StartGame();
	
		if (waiting < 90) {
			parent.background(100);
			parent.text("LOADING", parent.width/2, parent.height/2);
			waiting++;
			return;
		}
		
		TestRestart();
	}
	
	public void TestRestart() {
		
        
    	DDHandCursor handCursor = new DDHandCursor(parent);
    	this.gameManager.addObject(handCursor);
        DDPlatform platform;
  
     // FORM PINT GLASS bottom
        //Pint Glass Left Side
        platform = new DDPlatform(parent, 0 + parent.width / 3, parent.height/2, 20, 300 , 170);
    	platform.start();
    	this.gameManager.addObject(platform);
    	this.gameManager.addGameBoundingBoxes(platform);
    	//Pint Glass right Side
    	platform = new DDPlatform(parent, parent.width - parent.width / 3, parent.height/2, 20, 300 , 190);
    	platform.start();
    	this.gameManager.addObject(platform);
    	this.gameManager.addGameBoundingBoxes(platform);
    	//Pint Glass Bottom
    	platform = new DDPlatform(parent, parent.width/2, parent.height - parent.height/5, 180, 20 , 0);
    	platform.start();
    	this.gameManager.addObject(platform);
    	this.gameManager.addGameBoundingBoxes(platform);

     		
	this.gameManager.StartAll();
	this.started = true;
	}
 
	public void UpdateAll(){
	        super.UpdateAll();
	        parent.fill(255);
	        parent.textSize(20);
	        parent.text("PRESS B TO RESTART", 5, 20);
	}

}
