package dRink;

import nSideEngine.*;
import processing.core.PApplet;


public class DDLauncher extends DDBaseLauncher{
	public boolean started = false;
	int waiting = 0;
	int drinksFilled = 0;
	int drinksOverFilled = 0;

	public DDLauncher(PApplet p) {
		super(p);
	}
	
	public void keyPressed(char key, int keyCode) {
		super.keyPressed(key, keyCode);
		if (key == 'b' || key == 'B') {
			drinksFilled = 0;
			drinksOverFilled = 0;
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
		DDDrinkSpawn player = new DDDrinkSpawn(parent, this, 0 , 0 /2,60, 60);
        player.start();
        this.gameManager.addObject(player);
        this.gameManager.addPlayerGameObjects(player);
        this.gameManager.addGameBoundingBoxes(player);
       
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
        this.gameManager.addGameBoundingBoxes(handCursor);
        DDPlatform platform;
  
     // FORM PINT GLASS bottom
        //Pint Glass Left Side
        platform = new DDPlatform(parent, (0 + parent.width / 3) - 30, parent.height/2, 20, 300 , 0);
    	platform.start();
    	this.gameManager.addObject(platform);
    	this.gameManager.addGameBoundingBoxes(platform);
    	//Pint Glass right Side
    	platform = new DDPlatform(parent, (parent.width - parent.width / 3) + 30, parent.height/2, 20, 300 , 0);
    	platform.start();
    	this.gameManager.addObject(platform);
    	this.gameManager.addGameBoundingBoxes(platform);
    	//Pint Glass Bottom
    	platform = new DDPlatform(parent, parent.width/2, parent.height - parent.height/5, 260, 20 , 0);
    	platform.start();
    	this.gameManager.addObject(platform);
    	this.gameManager.addGameBoundingBoxes(platform);

     		
	this.gameManager.StartAll();
	this.started = true;
	}
 
	public void UpdateAll(){
	        super.UpdateAll();
	    	waiting ++;
	        parent.fill(255);
	        parent.textSize(20);
	        parent.text("PRESS B TO RESTART", 5, 20);
	        parent.text("HOLD P TO POUR", 5, 40);
	        parent.text("Drinks Filled " + drinksFilled, parent.width - 300, 20);
	        parent.text("Drinks Over Filled " + drinksOverFilled, parent.width - 300, 40);
	}

}
