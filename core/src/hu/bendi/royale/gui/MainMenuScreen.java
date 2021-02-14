package hu.bendi.royale.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen extends Screen {
    @Override
    public void init() {

    }

    @Override
    public void render(SpriteBatch spriteBatch, float delta) {
        drawFont("Menu", Gdx.graphics.getHeight() >> 1, Gdx.graphics.getWidth() >> 1);
        drawFont("Játék", Gdx.graphics.getHeight() >> 1 + 10, Gdx.graphics.getWidth() >> 1);
    }
}
