package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GGJ16;

public class LoginScreen implements Screen {

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Texture bg;
    private TextField textPassword;
    private TextField textEmail;
    private TextButton buttonLogin;
    private Skin skin;
    private Stage stage;
    public LoginScreen(GGJ16 game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        stage=new Stage(new StretchViewport(1280,720));
        Gdx.input.setInputProcessor(stage);
        skin=new Skin(Gdx.files.internal("uiskin.json"));
        buttonLogin=new TextButton("Login",skin);
        buttonLogin.setPosition(camera.position.x-150, camera.position.y-50);
        buttonLogin.setSize(300, 60);
        buttonLogin.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button) {
                buttonLogin.setText("Senin ben anua goyin");
                doSmtng();
            }
        });
        textEmail=new TextField("",skin);
        textEmail.setMessageText("E-mail Address:");
        textEmail.setPosition(camera.position.x - 150, camera.position.y + 130);
        textEmail.setSize(300, 60);
        textPassword=new TextField("",skin);
        textPassword.setMessageText("Password:");
        textPassword.setSize(300, 60);
        textPassword.setPosition(camera.position.x-150, camera.position.y+40);
        textPassword.setPasswordMode(true);
        textPassword.setPasswordCharacter('#');



    }


    @Override
    public void show() {
        batch=new SpriteBatch();
        stage.addActor(buttonLogin);
        stage.addActor(textEmail);
        stage.addActor(textPassword);
        batch.setProjectionMatrix(camera.combined);
        bg=game.textures.loginScreenBG;

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(bg,0,0);
        batch.end();
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void doSmtng(){
        String password = textPassword.getText();
        String email = textEmail.getText();

        System.out.println(password + " " + email);
    }
}
