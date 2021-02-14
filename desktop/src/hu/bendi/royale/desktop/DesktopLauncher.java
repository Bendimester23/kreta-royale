package hu.bendi.royale.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import hu.bendi.royale.KretaRoyale;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = true;
		config.title = "Kréta Royale";
		config.vSyncEnabled = true;
		new LwjglApplication(new KretaRoyale(), config);
	}
}
