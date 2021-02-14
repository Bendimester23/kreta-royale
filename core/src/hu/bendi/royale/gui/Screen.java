package hu.bendi.royale.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.bendi.royale.KretaRoyale;

import java.util.ArrayList;
import java.util.List;

public abstract class Screen {

    private List<Widget> widgets;

    public void init() {
        widgets = new ArrayList<>();
    }

    public void addWidget(Widget widget) {
        widgets.add(widget);
    }

    public void render(SpriteBatch spriteBatch, float delta) {
        widgets.forEach(widget -> widget.render(delta));
    }

    protected void drawFont(String text, float x, float y) {
        KretaRoyale.INSTANCE.getTextRenderer().renderText(text, x, y);
    }



    public void onOpen() {
    }

    public void close() {

    }
}
