package hu.bendi.royale.scene.menus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.bendi.royale.scene.Scene;

public class MainMenuScene extends Scene {

    @Override
    public void init() {
        System.out.println("Loaded main menu!");
        this.openScreen("misc:loading");
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
    }
}
