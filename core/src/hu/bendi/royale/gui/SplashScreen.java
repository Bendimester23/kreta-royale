package hu.bendi.royale.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.bendi.royale.KretaRoyale;
import hu.bendi.royale.gui.widgets.TextWidget;
import hu.bendi.royale.input.InputManager;
import hu.bendi.royale.renderer.TextRenderer;


public class SplashScreen extends Screen {
    @Override
    public void init() {
        super.init();
        System.out.println("Init.");
        addWidget(new TextWidget(Gdx.graphics.getHeight() >> 1, Gdx.graphics.getWidth() >> 1, "Kréta Royale"));
        addWidget(new TextWidget(Gdx.graphics.getHeight() >> 2, Gdx.graphics.getWidth() >> 2, "By Bendi"));
    }

    @Override
    public void render(SpriteBatch spriteBatch, float delta) {
        super.render(spriteBatch, delta);
        TextRenderer txt = KretaRoyale.INSTANCE.getTextRenderer();
        txt.renderText("asd", InputManager.x, InputManager.y, 0xff00ffaa);
    }
}
