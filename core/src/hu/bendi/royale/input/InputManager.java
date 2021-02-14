package hu.bendi.royale.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputManager implements InputProcessor {

	public static int x;
	public static int y;

	public static int mX;
	public static int mY;

	@Override
	public boolean keyDown(int keycode) {
        if (keycode == 131) {
            Gdx.app.exit();
            return true;
        }
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		x = screenX;
		y = screenY;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		x = screenX;
		y = screenY;
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		mX = screenX;
		mY = screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
