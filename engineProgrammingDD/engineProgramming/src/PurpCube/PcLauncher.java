package PurpCube;

import nSideEngine.*;
import processing.core.PApplet;


public class PcLauncher extends PcBaseLauncher{
	public boolean started = false;
	int waiting = 0;

	public PcLauncher(PApplet p) {
		super(p);
	}
	
	public void keyPressed(char key, int keyCode) {
		super.keyPressed(key, keyCode);
		if (key == 'b' || key == 'B') {
			this.ReLoad();
		}
	}
	
	public void keyReleased(char key, int keyCode) {
		super.keyReleased(key, keyCode);
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
		
        PcPlayer player = new PcPlayer(parent, parent.width/2,parent.height/2,60, 60);
        player.start();
        this.gameManager.addObject(player);
        this.gameManager.addPlayerGameObjects(player);
        PcCamera camera = new PcCamera(parent, player, 99);
        camera.cameraOffset.y = 90;
        this.gameManager.addObject(camera);
        int platforms = 500;
        PcTile platform;
        int tw = 50;
        int th = 20;
        int numPlatformsX = 2 * parent.width / tw;
        int numPlatformsY = 2 * parent.height / th;
        for (int i = 0; i < platforms; i++) {
        	int x =(int) parent.random(0, numPlatformsX) * tw;
        	int y = (int) parent.random(-numPlatformsY, numPlatformsY) * th;
        	platform = new Tile(parent, x, y, tw, th);
        	platform.start();
        	this.gameManager.addObject(platform);
        	this.gameManager.addGameBoundingBoxes(platform);
        }
        
      
        
        
     // GROUND

     		for (int i = 0; i < 40; i++) {
     			platform = new PcTile(parent, i * tw, parent.height * 2, tw, th);
     			platform.start();
     			platform.strokeColour = parent.color(120, 0, 255);
     			platform.fillColour = parent.color(120, 0, 255);
     			this.gameManager.addObject(platform);
     			this.gameManager.addGameBoundingBoxes(platform);
     		}

     		// left
     		for (int i = 0; i < 200; i++) {
     			platform = new PcTile(parent, 0, (-parent.height * 3) + (th + 2) * i, tw, th);
     			platform.start();
     			platform.strokeColour = parent.color(120, 0, 255);
     			platform.fillColour = parent.color(120, 0, 255);
     			this.gameManager.addObject(platform);
     			this.gameManager.addGameBoundingBoxes(platform);
     		}
     		// right
     		for (int i = 0; i < 200; i++) {
     			platform = new PcTile(parent, parent.width * 2, (-parent.height * 3) + th * i, tw, th);
     			platform.start();
     			platform.strokeColour = parent.color(120, 0, 255);
     			platform.fillColour = parent.color(120, 0, 255);
     			this.gameManager.addObject(platform);
     			this.gameManager.addGameBoundingBoxes(platform);
     		}
	
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
