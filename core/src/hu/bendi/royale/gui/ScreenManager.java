package hu.bendi.royale.gui;

import java.util.HashMap;
import java.util.function.Supplier;

public class ScreenManager {
    private HashMap<String, Supplier<Screen>> screens;

    private ScreenManager() {
        screens = new HashMap<>();
        init();
    }

    public void init() {
        register("misc:loading", SplashScreen::new);
    }

    public void register(String name, Supplier<Screen> screenSupplier) {
        screens.put(name, screenSupplier);
    }

    public static ScreenManager create() {
        return new ScreenManager();
    }

    public Screen getScreen(String name) {
        if (screens.containsKey(name)) return screens.get(name).get();
        return new DefaultScreen(name);
    }
}
