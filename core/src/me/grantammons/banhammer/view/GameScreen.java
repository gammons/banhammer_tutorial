package me.grantammons.banhammer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by grantammons on 5/31/15.
 */
public class GameScreen implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private PlayerView playerView;
    private GameInputProcessor inputprocessor;

    int WORLD_WIDTH = 128;
    int WORLD_HEIGHT = 128;

    public GameScreen(GameInputProcessor inputProcessor) {
        setupCamera();
        this.inputprocessor = inputProcessor;
        batch = new SpriteBatch();
        playerView = new PlayerView();

        inputProcessor.addListener(playerView);
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(cam.combined);

        batch.begin();
        playerView.draw(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        cam.viewportHeight = WORLD_HEIGHT;
        cam.viewportWidth = (WORLD_HEIGHT / (float)height) * width;
        cam.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void setupCamera() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(WORLD_WIDTH, WORLD_HEIGHT * (h / w));
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
    }
}
