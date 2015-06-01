package me.grantammons.banhammer.view;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by grantammons on 5/31/15.
 */
public class GameInputProcessor implements InputProcessor{

    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean downPressed;

    private List<InputListener> listeners;

    public GameInputProcessor() {
        listeners = new ArrayList<InputListener>();
    }

    public void addListener(InputListener listener) {
        listeners.add(listener);
    }


    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.LEFT:
                if (leftPressed == false)
                    notifyListeners(Input.Keys.LEFT);
                leftPressed = true;
                break;
            case Input.Keys.RIGHT:
                if (rightPressed == false)
                    notifyListeners(Input.Keys.RIGHT);
                rightPressed = true;
                break;
            case Input.Keys.UP:
                if (upPressed == false)
                    notifyListeners(Input.Keys.UP);
                upPressed = true;
                break;
            case Input.Keys.DOWN:
                if (downPressed == false)
                    notifyListeners(Input.Keys.DOWN);
                downPressed = true;
                break;
        }
        return false;
    }

    private void notifyListeners(int keycode) {
        Iterator<InputListener> iterator = listeners.iterator();

        while (iterator.hasNext()) {
            InputListener listener = iterator.next();
            listener.notify(keycode);
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyup"+keycode);
        switch(keycode) {
            case Input.Keys.LEFT:
                leftPressed = false;
                break;
            case Input.Keys.RIGHT:
                rightPressed = false;
                break;
            case Input.Keys.UP:
                upPressed = false;
                break;
            case Input.Keys.DOWN:
                downPressed = false;
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
