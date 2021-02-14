package hu.bendi.royale.gui.widgets;

import com.badlogic.gdx.math.Vector2;
import hu.bendi.royale.gui.Widget;
import hu.bendi.royale.input.InputManager;
import hu.bendi.royale.utils.RenderHelper;

public class TextWidget extends Widget {

    private String text;

    public TextWidget(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public void render(float delta) {
        if (InputManager.mX > x && InputManager.mY > y) RenderHelper.DrawDebugLine(new Vector2(x, y), new Vector2(x, y + 10));
        renderText(text, x, y);
    }
}
