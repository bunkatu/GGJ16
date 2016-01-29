package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GGJ16;

public class LoadingScreen implements Screen {

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Texture bg;
    private boolean everythingLoaded = false;
    private boolean splash = true, bgLoaded = false, rendered = false;

    public LoadingScreen(GGJ16 game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {

        if (!rendered){
            rendered = true;
        } else {
            if(splash && bgLoaded){
                loadTextures();
            }

            if (everythingLoaded) {
                game.setScreen(new LoginScreen(game));
            }
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        batch.draw(bg,0,0);
        batch.end();

    }

    public void loadTextures(){

        game.textures.load();

        splash = false;
        everythingLoaded = true;

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        batch.setProjectionMatrix(camera.combined);

        bg = new Texture(Gdx.files.internal("screens/loadingScreen.jpg"));

        bgLoaded = true;

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}
