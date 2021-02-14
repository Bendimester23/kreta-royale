package hu.bendi.royale.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DefaultScreen extends Screen {

    private String notFound;

    public DefaultScreen(String name) {
        notFound = name;
    }

    @Override
    public void init() {

    }

    @Override
    public void render(SpriteBatch spriteBatch, float delta) {
        this.drawFont("Screen '" + notFound + "' not found", 20, 0);
    }
}
