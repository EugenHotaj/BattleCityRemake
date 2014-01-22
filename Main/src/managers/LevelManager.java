package managers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LevelManager {
	
	private int currentLevel = 0;
	private ArrayList<Level> levels;
	
	private Level testLevel;
	private Level battleCity;
	
	public LevelManager(Texture spriteSheet){
		levels = new ArrayList<Level>();
		
		testLevel = new Level("Levels/TestLevel.tmx", spriteSheet, 5, 360);
		levels.add(testLevel);
		
		battleCity = new Level("Levels/BattleCity.tmx", spriteSheet, 5, 300);
		levels.add(battleCity);
		
	}
	
	
	public int getCurrentLevelNumber(){
		return currentLevel;
	}
	
	public Level getCurrentLevel(){
		return levels.get(currentLevel);
	}
	
	public void nextLevel(){
		currentLevel++;
	}
	
	public void update(float dt){
		
		if(levels.get(currentLevel).getNumEnemiesOnScreen() < 4 && levels.get(currentLevel).getEnemiesLeft() > 0){
			levels.get(currentLevel).spawnEnemy();
		}
		
		levels.get(currentLevel).update(dt);
	}
	
	public void drawLevelFor(){
		levels.get(currentLevel).drawForeground();
	}
	
	public void draw(SpriteBatch batch){
		levels.get(currentLevel).draw(batch);
	}
	
	public void drawShapes(ShapeRenderer sr){
		levels.get(currentLevel).drawShapes(sr);
	}
	
	public void drawLevelBack(){
		levels.get(currentLevel).drawBackground();
	}

}
