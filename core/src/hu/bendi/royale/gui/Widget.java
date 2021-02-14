package hu.bendi.royale.gui;

import hu.bendi.royale.KretaRoyale;

public abstract class Widget {
    public int x,y = 0;
    public int sX, sY = 0;

    public abstract void render(float delta);

    protected void renderText(String text, float x, float y) {
        KretaRoyale.INSTANCE.getTextRenderer().renderText(text, x, y);
    }
}
