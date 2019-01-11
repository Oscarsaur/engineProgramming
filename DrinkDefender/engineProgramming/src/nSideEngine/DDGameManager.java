package nSideEngine;

import processing.core.*;
import java.util.ArrayList;

import nSideEngine.DDBoundingBox;
import nSideEngine.DDGameObject;


public class DDGameManager extends DDProcessingEntity {
	
	
	public int background = 0;
	private ArrayList<DDGameObject> gameObjects;
	private ArrayList<DDGameObject> playerGameObjects;
    public static ArrayList<DDTransform> gameBoundingBoxes;
    public static int frameCount = 0;
    
	public DDGameManager(PApplet p) {
		super(p);
		this.Name = "GameManager";

        this.Init();
		
	}
	
	public void Init() {
		gameObjects = new ArrayList<DDGameObject>();
		playerGameObjects = new ArrayList<DDGameObject>();
		gameBoundingBoxes = new ArrayList<DDTransform>();
	}
	public void addGameBoundingBoxes(DDGameObject b){
		
    	gameBoundingBoxes.add(b.transform);
    	b.transform.ID = gameBoundingBoxes.size();
    }
	
    public void addPlayerGameObjects(DDGameObject b){
    	playerGameObjects.add(b);
    }
    
	public void addObject(DDGameObject g) {
		gameObjects.add(g);
	}
	
	
	
	public void StartAll() {
		
		for (int i = 0; i < gameObjects.size(); i++) {
			DDGameObject g = gameObjects.get(i);
			g.start();
		}
	}
	

	public void UpdateAll() {
		parent.pushMatrix();
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
