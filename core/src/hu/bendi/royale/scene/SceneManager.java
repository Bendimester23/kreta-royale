package hu.bendi.royale.scene;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.bendi.royale.scene.menus.MainMenuScene;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SceneManager {
    private Map<String, Supplier<Scene>> scenes;
    public Scene currentScene;

    private SpriteBatch batch;
    private Camera cam;

    private SceneManager(SpriteBatch batch, Camera camera) {
        this.batch = batch;
        this.cam = camera;
        scenes = new HashMap<>();
        loadAll();
    }

    public void loadAll() {
        this.register("mainmenu", MainMenuScene::new);
    }

    private void register(String name, Supplier<Scene> scene) {
        scenes.put(name, scene);
    }

    public void loadScene(String name) {
        if (currentScene != null) closeScene();
        if (scenes.containsKey(name)) currentScene = scenes.get(name).get();
        currentScene.init();
    }

    public void closeScene() {

    }

    public void render() {
        if (currentScene != null) currentScene.render(batch);
    }

    public static SceneManager create(SpriteBatch batch, Camera cam) {
        return new SceneManager(batch, cam);
    }
}
