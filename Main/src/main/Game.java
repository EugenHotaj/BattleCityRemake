package main;

import managers.GameKeys;
import managers.InputProcessor;
import managers.Level;
import managers.LevelManager;
import actors.Bullet;
import actors.Player;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Game implements ApplicationListener {
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static OrthographicCamera camera;
	
	Texture spriteSheet;
	
	SpriteBatch batch;
	ShapeRenderer sr;
	
	public static Player player;
	LevelManager lvlManager;
	
	int shootTimer;
	
	public void create () {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		/* Set up the camera */
		camera = new OrthographicCamera(WIDTH,HEIGHT);
		camera.setToOrtho(false, 416, 416);;
		camera.update();
		
		/* Set up variables */
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		spriteSheet = new Texture(Gdx.files.internal("TanksSpriteSheet.png"));
		lvlManager = new LevelManager(spriteSheet);
		player = new Player(spriteSheet, Level.PLAYER_START_POS, 8, 8, 8, 0);
		shootTimer = 0;
		
		/* Change Input Processor */
		Gdx.input.setInputProcessor(new InputProcessor());
	}

	public void render () {
		
		/* Clear the screen */
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    
	    batch.setProjectionMatrix(camera.combined);
	    
	    /*****************************************
	     *  			  UPDATING               *
	     *****************************************/
	    shootTimer ++;
	    
	    if(GameKeys.isDown(GameKeys.LEFT)){
	    	player.setVelocity(Player.LEFT);
	    }
	    else if(GameKeys.isDown(GameKeys.UP)){
	    	player.setVelocity(Player.UP);
	    }
	    else if(GameKeys.isDown(GameKeys.RIGHT)){
	    	player.setVelocity(Player.RIGHT);
	    }
	    else if(GameKeys.isDown(GameKeys.DOWN)){
	    	player.setVelocity(Player.DOWN);
	    }
	    else{
	    	player.setVelocity(Player.STOPPED);
	    }
	    
	    if(lvlManager.getCurrentLevel().resolveCollisions(player.getCollisionRect())){
	    	player.setVelocity(Player.STOPPED);
	    }
	    
	    for(int i = 0; i< lvlManager.getCurrentLevel().getEnemiesList().size(); i++){
	    	for(int j = 0; j < lvlManager.getCurrentLevel().getEnemiesList().get(i).getBullets().size(); j++){
	    		if(lvlManager.getCurrentLevel().getEnemiesList().get(i).getBullets().get(j).getCollisionRect().overlaps(player.getCollisionRect())){
	    			lvlManager.getCurrentLevel().getEnemiesList().get(i).getBullets().get(j).setAlive(false);;
	    			
	    			//TODO: Add logic to remove player
	    		}
	    	}
	    }	
	    
	    if(GameKeys.isDown(GameKeys.SPACE)){
	    	if(shootTimer > 30){
	    		player.shoot(Bullet.BULLET_PLAYER);
	    		shootTimer = 0;
	    	}
	    }
	    
	    player.update(Gdx.graphics.getDeltaTime());
	    
	    for(int i = 0; i < player.getBullets().size(); i++){
	    	if(lvlManager.getCurrentLevel().resloveDestructible(player.getBullets().get(i).getCollisionRect())){
	    		player.getBullets().get(i).setAlive(false);
	    		continue;
	    	}
	    	if(lvlManager.getCurrentLevel().resloveEnemyCollisions(player.getBullets().get(i).getCollisionRect())){
	    		player.getBullets().get(i).setAlive(false);
	    		continue;
	    	}
	    }
	    
	    lvlManager.update(Gdx.graphics.getDeltaTime());
	    
	    GameKeys.update();
	    	    
	    /*****************************************
	     *  			   DRAWING               *
	     *****************************************/
	    lvlManager.drawLevelBack();
	    
	    batch.begin();
	    player.draw(batch);
	    lvlManager.draw(batch);
	    batch.end();
	    
	    sr.begin(ShapeType.Filled);
	    player.drawDebug(sr);
	    lvlManager.drawShapes(sr);
	    sr.end();
	    
	    lvlManager.drawLevelFor();
	}

	public void resize (int width, int height) {
	
	}

	public void pause () {
	
	}

	public void resume () {
	
	}

	public void dispose () {	
	
	}
}