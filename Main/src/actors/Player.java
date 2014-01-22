package actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject {
	

	
	public Player(Texture spriteSheet, Vector2 position, int spriteSheetRows,
			int spriteSheetCols, int numFrames, int animationStartRow){		
		super(spriteSheet, position, spriteSheetRows, spriteSheetCols, numFrames, animationStartRow);
	}
	
	@Override public void update(float dt){
		
		super.update(dt);
	}
	
	@Override public void draw(SpriteBatch batch){
		super.draw(batch);
	}
	
	@Override public void drawDebug(ShapeRenderer sr){
		sr.setColor(Color.YELLOW);
		super.drawDebug(sr);
	
	}	
}
