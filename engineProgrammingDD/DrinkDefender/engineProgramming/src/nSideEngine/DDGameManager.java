package nSideEngine;

import processing.core.*;
import java.util.ArrayList;

import nSideEngine.DDBoundingBox;
import nSideEngine.DDGameObject;


public class DDGameManager extends DDProcessingEntity {
	
	
	public int background = 0;
	private ArrayList<DDGameObject> gameObjects;
	private ArrayList<DDGameObject> playerGameObjects;
    public static ArrayList<DDBoundingBox> gameBoundingBoxes;
    public static int frameCount = 0;
    public static PVector offset = new PVector(0,0);
    public static PVector screenOffset = new PVector(0,0);
	public DDGameManager(PApplet p) {
		super(p);
		this.Name = "GameManager";
		
        screenOffset.x = parent.width / 2;
        screenOffset.y = parent.height / 2;
        this.Init();
		
	}
	
	public void Init() {
		gameObjects = new ArrayList<DDGameObject>();
		playerGameObjects = new ArrayList<DDGameObject>();
		gameBoundingBoxes = new ArrayList<DDBoundingBox>();
	}
	public void addGameBoundingBoxes(DDGameObject b){
    	gameBoundingBoxes.add(b.transform.NewWorldPcBoundingBox());
    }
	
    public void addPlayerGameObjects(DDGameObject b){
    	playerGameObjects.add(b);
    }
    
	public void addObject(DDGameObject g) {
		gameObjects.add(g);
	}
	
	public void removeObject(DDGameObject g) {
		gameObjects.remove(gameObjects.lastIndexOf(g));
	}
	
	
	
	public void StartAll() {
		
		for (int i = 0; i < gameObjects.size(); i++) {
			DDGameObject g = gameObjects.get(i);
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
			DDGameObject g = gameObjects.get(i);
			g.update();
			g.render();
		}
		frameCount ++;
		parent.popMatrix();
	}
	
    public void keyPressed(char key, int keyCode) {
    	for(int i = 0; i < playerGameObjects.size(); i++){
        	
            DDGameObject g = playerGameObjects.get(i);
            g.keyPressed(key, keyCode);
        }
    	
    }
    
    public void keyReleased(char key, int keyCode) {
    	for(int i = 0; i < playerGameObjects.size(); i++){
        	
            DDGameObject g = playerGameObjects.get(i);
            g.keyReleased(key, keyCode);
        }
    	
    }
	

}
