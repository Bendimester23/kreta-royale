package hu.bendi.royale.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.bendi.royale.KretaRoyale;

public abstract class Screen {

    public abstract void init();

    public abstract void render(SpriteBatch spriteBatch, float delta);

    protected void drawFont(SpriteBatch sb, String text, float x, float y) {
        if (!sb.isDrawing()) throw new UnsupportedOperationException("Not drawing");
        KretaRoyale.font.draw(sb,text,x,y);
    }
}
