package hu.bendi.royale;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2D;
import hu.bendi.royale.gui.ScreenManager;
import hu.bendi.royale.input.InputManager;
import hu.bendi.royale.renderer.TextRenderer;
import hu.bendi.royale.renderer.TextureManager;
import hu.bendi.royale.scene.SceneManager;

public class KretaRoyale extends ApplicationAdapter {

	private SpriteBatch batch;

	private OrthographicCamera cam;

	private TextRenderer textRenderer;
	private SceneManager sceneManager;
	private ScreenManager screenManager;
	private TextureManager textureManager;

	public static KretaRoyale INSTANCE;
	
	@Override
	public void create () {
		INSTANCE = this;
		Box2D.init();
		Gdx.input.setInputProcessor(new InputManager());

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		batch = new SpriteBatch();

		textRenderer = TextRenderer.of(batch, "ArchitectsDaughter");

		textRenderer.useFont("ArchitectsDaughter", 20);

		cam = new OrthographicCamera(w, h);

		sceneManager = SceneManager.create(batch, cam);
		screenManager = ScreenManager.create();
		textureManager = new TextureManager();

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();
		sceneManager.loadScene("mainmenu");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		sceneManager.render();
		batch.end();
	}

	public Matrix4 getProjectionMatrix() {
		return cam.combined;
	}

	public TextRenderer getTextRenderer() {
		return textRenderer;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public TextureManager getTextureManager() {
		return textureManager;
	}
}
