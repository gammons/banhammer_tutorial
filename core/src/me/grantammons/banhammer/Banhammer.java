package me.grantammons.banhammer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import me.grantammons.banhammer.view.GameInputProcessor;
import me.grantammons.banhammer.view.GameScreen;

public class Banhammer extends Game {

    private GameInputProcessor inputProcessor;

	@Override
	public void create () {
        inputProcessor = new GameInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
        GameScreen gameScreen = new GameScreen(inputProcessor);
        setScreen(gameScreen);

	}

	@Override
	public void render () {
        super.render();
	}
}
