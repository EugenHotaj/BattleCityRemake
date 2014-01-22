package actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends GameObject {
	
	private int random;
	private boolean alive;
	
	public Enemy(Texture spriteSheet, Vector2 position, int spriteSheetRows,
			int spriteSheetCols, int numFrames, int animationStartRow){		
		super(spriteSheet, position, spriteSheetRows, spriteSheetCols, numFrames, animationStartRow);
		
		random = 0;
		velocity = Vector2.Zero;
		
		alive = true;
		
		randomMovement();
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public void setAlive(boolean b){
		alive = b;
	}
	
	public void randomMovement(){
		random = (int)(Math.random() * 100);
		
		switch(currentFacing){
		case LEFT:
			if(random < 15){ //Turn Right
				setVelocity(RIGHT);
			}
			else if(random < 30){ //Turn Down
					setVelocity(DOWN);
			}
			else if (random < 45){ // Turn Up
				setVelocity(UP);
			}
			else{ //Idle
				setVelocity(STOPPED);
			}
			break;
		case RIGHT:
			if(random < 15){ //Turn Left
				setVelocity(LEFT);
			}
			else if(random < 30){ //Turn Down
				setVelocity(DOWN);
			}
			else if (random < 45){ // Turn Up
				setVelocity(UP);
			}
			else{ //Idle
				setVelocity(STOPPED);
			}
			break;
		case UP:
			if(random < 15){ //Turn Right
				setVelocity(RIGHT);
			}
			else if(random < 30){ //Turn Down
				setVelocity(DOWN);
			}
			else if (random < 45){ // Turn Left
				setVelocity(LEFT);
			}
			else{ //Idle
				setVelocity(STOPPED);
			}
		case DOWN:
			if(random < 15){ //Turn Right
				setVelocity(RIGHT);
			}
			else if(random < 30){ //Turn Left
				setVelocity(LEFT);
			}
			else if (random < 45){ // Turn Up
				setVelocity(UP);
			}
			else{ //Idle
				setVelocity(STOPPED);
			}
			break;
		case IDLE:
			if(random < 20){ //Turn Right
				setVelocity(RIGHT);
			}
			else if(random < 40){ //Turn Down
				setVelocity(DOWN);
			}
			else if (random < 60){ // Turn UP
				setVelocity(UP);
			}
			else if (random < 80){ // Turn Left
				setVelocity(LEFT);
			}
			break;
		}
	}
	
	@Override public void update(float dt){
		
		if(Math.random() < .01){
			randomMovement();
		}
		
		if(Math.random() < .01){
			shoot(Bullet.BULLET_PLAYER);
		}
		
		super.update(dt);
	}
	
	@Override public void draw(SpriteBatch batch){
		super.draw(batch);
	}
	
	@Override public void drawDebug(ShapeRenderer sr){
		sr.setColor(Color.RED);
		super.drawDebug(sr);
	}
}
