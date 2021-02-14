package hu.bendi.royale.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.bendi.royale.KretaRoyale;
import hu.bendi.royale.gui.Screen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Scene {
    public String name;
    public int id;

    private List<GameObject> actors;

    private Map<String, String> props;

    private List<Screen> openScreens;

    public Scene() {
        actors = new ArrayList<>();
        props = new HashMap<>();
        openScreens = new ArrayList<>();
    }

    public void closeAllScreens() {
        for (Screen screen: openScreens) {
            screen.close();
        }
        openScreens.clear();
    }

    public void empty() {
        for (GameObject object: actors) {
            object.destroy();
        }
        actors.clear();
    }

    public void openScreen(String name) {
        Screen toOpen = KretaRoyale.INSTANCE.getScreenManager().getScreen(name);
        openScreens.add(toOpen);
        toOpen.init();
        toOpen.onOpen();
    }

    public void render(SpriteBatch batch) {
        float delta = Gdx.graphics.getDeltaTime();
        openScreens.forEach(screen -> screen.render(batch, delta));
    }

    public abstract void init();
}
