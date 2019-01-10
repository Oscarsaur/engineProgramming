package nSideEngine;

import processing.core.*;
import java.util.ArrayList;

import nSideEngine.PcBoundingBox;
import nSideEngine.PcGameObject;


public class PcGameManager extends PcProcessingEntity {
	
	
	public int background = 0;
	private ArrayList<PcGameObject> gameObjects;
	private ArrayList<PcGameObject> playerGameObjects;
    public static ArrayList<PcBoundingBox> gameBoundingBoxes;
    public static int frameCount = 0;
    public static PVector offset = new PVector(0,0);
    public static PVector screenOffset = new PVector(0,0);
	public PcGameManager(PApplet p) {
		super(p);
		this.Name = "GameManager";
		
        screenOffset.x = parent.width / 2;
        screenOffset.y = parent.height / 2;
        this.Init();
		
	}
	
	public void Init() {
		gameObjects = new ArrayList<PcGameObject>();
		playerGameObjects = new ArrayList<PcGameObject>();
		gameBoundingBoxes = new ArrayList<PcBoundingBox>();
	}
	public void addGameBoundingBoxes(PcGameObject b){
    	gameBoundingBoxes.add(b.transform.NewWorldPcBoundingBox());
    }
	
    public void addPlayerGameObjects(PcGameObject b){
    	playerGameObjects.add(b);
    }
    
	public void addObject(PcGameObject g) {
		gameObjects.add(g);
	}
	
	public void removeObject(PcGameObject g) {
		gameObjects.remove(gameObjects.lastIndexOf(g));
	}
	
	
	
	public void StartAll() {
		
		for (int i = 0; i < gameObjects.size(); i++) {
			PcGameObject g = gameObjects.get(i);
			g.start();
		}
	}
	
//	public void checkCollisions() {
//   	 for(int i = 0; i < gameBoundingBoxes.size(); i++){
//  		 PcBoundingBox bb = gameBoundingBoxes.get(i);
//   		 for(int j = 0; j < playerGameObjects.size(); j++){
//  	            PcGameObject p = playerGameObjects.get(j);
//   	            p.checkCollisions(bb);
//   	           
//   	        }
//           
//      }
//   }
	
	public void UpdateAll() {
		parent.pushMatrix();
		parent.translate(offset.x,  offset.y);
		parent.background(background);
		for(int i = 0; i < gameObjects.size(); i++) {
			PcGameObject g = gameObjects.get(i);
			g.update();
			g.render();
		}
		frameCount ++;
		parent.popMatrix();
	}
	
    public void keyPressed(char key, int keyCode) {
    	for(int i = 0; i < playerGameObjects.size(); i++){
        	
            PcGameObject g = playerGameObjects.get(i);
            g.keyPressed(key, keyCode);
        }
    	
    }
    
    public void keyReleased(char key, int keyCode) {
    	for(int i = 0; i < playerGameObjects.size(); i++){
        	
            PcGameObject g = playerGameObjects.get(i);
            g.keyReleased(key, keyCode);
        }
    	
    }
	

}
