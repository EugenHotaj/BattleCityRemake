package actors;

import main.Game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet{
	
	private Vector2 position;
	private Vector2 velocity;
	private boolean alive;
	
	public static final int BULLET_PLAYER = 0;
	public static final int BULLET_ENEMY = 1;
	public static final int RADIUS = 3;
	
	public static final int BULLET_SPEED = 5;
	
	public Bullet(Vector2 position, Vector2 velocity) {
		this.position = position;
		this.velocity = velocity;
		this.alive = true;
	}
	
	public Rectangle getCollisionRect(){
		return new Rectangle(position.x - RADIUS, position.y - RADIUS, 2*RADIUS, 2*RADIUS);
	}
	
	public void update(float dt){
		position.x += velocity.x;
		position.y += velocity.y;
		
		if(position.x < 0 - RADIUS){
			alive = false;
		}
		else if(position.x > Game.WIDTH){
			alive = false;
		}
		else if(position.y > Game.HEIGHT){
			alive = false;
		}
		else if(position.y < 0 - RADIUS){
			alive = false;
		}
	}
	
	public void draw(ShapeRenderer sr){
		sr.circle(position.x, position.y, RADIUS);
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	public void setAlive(boolean b){
		alive = b;
	}
}
