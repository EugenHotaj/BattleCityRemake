package managers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class InputProcessor extends InputAdapter {
	
	@Override public boolean keyDown(int k){
		if(k == Keys.UP){
			GameKeys.setKey(GameKeys.UP, true);
		}
		else if(k == Keys.DOWN){
			GameKeys.setKey(GameKeys.DOWN, true);
		}
		else if(k == Keys.RIGHT){
			GameKeys.setKey(GameKeys.RIGHT, true);
		}
		else if(k == Keys.LEFT){
			GameKeys.setKey(GameKeys.LEFT, true);
		}
		else if(k == Keys.SPACE){
			GameKeys.setKey(GameKeys.SPACE, true);
		}
		return true;
	}
	
	@Override public boolean keyUp(int k){
		if(k == Keys.UP){
			GameKeys.setKey(GameKeys.UP, false);
		}
		else if(k == Keys.DOWN){
			GameKeys.setKey(GameKeys.DOWN, false);
		}
		else if(k == Keys.RIGHT){
			GameKeys.setKey(GameKeys.RIGHT, false);
		}
		else if(k == Keys.LEFT){
			GameKeys.setKey(GameKeys.LEFT, false);
		}
		else if(k == Keys.SPACE){
			GameKeys.setKey(GameKeys.SPACE, false);
		}
		return true;
	}
}
