package hu.bendi.royale.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import hu.bendi.royale.KretaRoyale;

import java.util.HashMap;
import java.util.Map;

public class TextureManager {
    private Map<String, Texture> cache;

    public TextureManager() {
        cache = new HashMap<>();
    }

    public static Texture tex(String name) {
        return KretaRoyale.INSTANCE.getTextureManager().getTexture(name);
    }

    public Texture getTexture(String name) {
        if (!cache.containsKey(name)) loadTexture(name);
        return cache.get(name);
    }

    private void loadTexture(String name) {
        cache.put(name, new Texture(Gdx.files.internal("resources/textures/" + name + ".png")));
    }
}
