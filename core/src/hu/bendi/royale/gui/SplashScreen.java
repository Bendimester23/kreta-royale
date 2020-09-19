package hu.bendi.royale.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import hu.bendi.royale.KretaRoyale;

public class SplashScreen extends Screen {

    private int frames;

    @Override
    public void init() {
        System.out.println("Init.");
    }

    @Override
    public void render(SpriteBatch spriteBatch, float delta) {
        frames++;
        KretaRoyale.font.draw(spriteBatch,"Kréta Royale", Gdx.graphics.getHeight() >> 1, Gdx.graphics.getWidth() >> 1, 0.1f, Align.topLeft, true);
        if (frames < 20) {
            KretaRoyale.font.draw(spriteBatch," . . . ", (Gdx.graphics.getHeight() >> 1) + 10, (Gdx.graphics.getWidth() >> 1) - 20);
        } else if (frames < 40) {
            KretaRoyale.font.draw(spriteBatch," o . .", (Gdx.graphics.getHeight() >> 1) + 10, (Gdx.graphics.getWidth() >> 1) - 20);
        } else if (frames < 60) {
            KretaRoyale.font.draw(spriteBatch," . o .", (Gdx.graphics.getHeight() >> 1) + 10, (Gdx.graphics.getWidth() >> 1) - 20);
        } else if (frames < 80) {
            KretaRoyale.font.draw(spriteBatch," . . o", (Gdx.graphics.getHeight() >> 1) + 10, (Gdx.graphics.getWidth() >> 1) - 20);
        } else if (frames < 100) {
            KretaRoyale.font.draw(spriteBatch," . . .", (Gdx.graphics.getHeight() >> 1) + 10, (Gdx.graphics.getWidth() >> 1) - 20);
        } else {
            frames = 0;
        }
    }
}
