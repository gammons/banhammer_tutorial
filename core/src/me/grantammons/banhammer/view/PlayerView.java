package me.grantammons.banhammer.view;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import me.grantammons.banhammer.core.Player;

/**
 * Created by grantammons on 5/31/15.
 */
public class PlayerView implements InputListener {
    int PIXEL_WIDTH = 16;
    int PIXEL_HEIGHT = 16;

    public Sprite sprite;
    private Player player;

    public PlayerView() {
        player = new Player();
        player.x = 0;
        player.y = 0;

        sprite = new Sprite(new Texture("player.png"));
        sprite.setSize(PIXEL_WIDTH, PIXEL_HEIGHT);
    }

    public void draw(Batch batch) {
        sprite.setPosition(player.x * PIXEL_WIDTH, player.y * PIXEL_HEIGHT);
        sprite.draw(batch);

    }

    @Override
    public void notify(int direction) {
        switch(direction) {
            case Input.Keys.UP: player.y++; break;
            case Input.Keys.DOWN: player.y--; break;
            case Input.Keys.LEFT: player.x--; break;
            case Input.Keys.RIGHT: player.x++; break;
        }

    }
}
