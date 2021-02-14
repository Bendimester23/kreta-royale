package hu.bendi.royale.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;
import java.util.Map;

public class TextRenderer {
    private Map<String, Font> fonts;
    private SpriteBatch batch;
    private BitmapFont selectedFont;

    private Color defaultColor;

    private TextRenderer(SpriteBatch batch, Map<String, Font> fonts, Color defaultColor) {
        this.fonts = fonts;
        this.batch = batch;
        selectedFont = ((Font)fonts.values().toArray()[0]).getFontForSize(12);
        this.defaultColor = defaultColor;
    }

    private TextRenderer(SpriteBatch batch, Map<String, Font> fonts) {
        this(batch, fonts, Color.WHITE);
    }

    public static TextRenderer of(SpriteBatch batch, String... fonts) {
        Map<String, Font> fontsMap = new HashMap<>(fonts.length);
        for (String font : fonts) {
            fontsMap.put(font, new Font(font));
        }
        return new TextRenderer(batch, fontsMap);
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void useFont(String font) {
        useFont(font, 12);
    }

    public void useFont(String font, int size) {
        if (fonts.containsKey(font)) selectedFont = fonts.get(font).getFontForSize(size);
    }

    public void renderText(CharSequence text, float x, float y) {
        selectedFont.setColor(defaultColor);
        selectedFont.draw(batch, text, x, (y - Gdx.graphics.getHeight()) * -1);
    }

    public void renderText(CharSequence text, float x, float y, int color) {
        selectedFont.setColor(new Color(color));
        selectedFont.draw(batch, text, x, (y - Gdx.graphics.getHeight()) * -1);
    }

    public static class Font {
        private Map<Integer, BitmapFont> cache;
        private String name;
        private FreeTypeFontGenerator generator;

        public Font(String name) {
            this.name = name;
            cache = new HashMap<>();
            System.out.println(Gdx.files.internal("resources/fonts/" + name + ".ttf").file().getAbsolutePath());
            generator = new FreeTypeFontGenerator(Gdx.files.internal("resources/fonts/" + name + ".ttf"));
            cacheSize(12);
        }

        public void cacheSize(int size) {
            if (cache.containsKey(size)) return;
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = size;
            cache.put(size, generator.generateFont(parameter));
            System.out.println("Successfully cached font '" + name + "' with size " + size + "!");
        }

        public BitmapFont getFontForSize(int size) {
            if (!cache.containsKey(size)) cacheSize(size);
            return cache.get(size);
        }
    }
}
