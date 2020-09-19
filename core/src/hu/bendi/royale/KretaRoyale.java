package hu.bendi.royale;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import hu.bendi.royale.gui.MainMenuScreen;
import hu.bendi.royale.gui.Screen;
import hu.bendi.royale.gui.SplashScreen;

import java.util.Timer;
import java.util.TimerTask;

public class KretaRoyale extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private CharSequence str = "Hello World!";
	public static BitmapFont font;

	Timer t;
	TimerTask tt;

	private Screen currentScreen;
	
	@Override
	public void create () {
		t = new Timer();
		tt = new TimerTask() {
			@Override
			public void run() {
				displayScreen(new MainMenuScreen());
			}
		};
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont(new BitmapFont.BitmapFontData(Gdx.files.internal("font2.fnt"),false), (TextureRegion) null,false);
		displayScreen(new SplashScreen());
		t.schedule(tt,5000);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if (currentScreen != null) {
			currentScreen.render(batch, Gdx.graphics.getDeltaTime());
		}
		batch.end();
	}

	public void displayScreen(Screen screen) {
		this.currentScreen = screen;
		this.currentScreen.init();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
