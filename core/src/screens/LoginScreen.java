package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GGJ16;

import network.login.Login;

public class LoginScreen implements Screen {

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Texture bg;
    private TextField textPassword;
    private TextField textEmail;
    private TextButton buttonLogin;
    private TextButton buttonRegister;
    private Skin skin;
    private Stage stage;
    private Table table;
    private boolean buttonClicked = false;
    private boolean buttonChanged = false;


    public LoginScreen(GGJ16 game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        stage=new Stage(new ScreenViewport());
        table=new Table();
        skin=new Skin(Gdx.files.internal("uiskin.json"));
        buttonLogin=new TextButton("Login",skin);
//        buttonLogin.setPosition(camera.position.x-150, camera.position.y-50);
//        buttonLogin.setSize(300, 60);
        buttonLogin.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                buttonLogin.setText("Logging in");
                buttonClicked = true;
            }
        });

        textEmail=new TextField("",skin);
        textEmail.setMessageText("E-mail Address:");
//        textEmail.setPosition(camera.position.x - 150, camera.position.y + 130);
//        textEmail.setSize(300, 60);
        textPassword=new TextField("",skin);
        textPassword.setMessageText("Password:");
//        textPassword.setSize(300, 60);
//        textPassword.setPosition(camera.position.x-150, camera.position.y+40);
        textPassword.setPasswordMode(true);
        textPassword.setPasswordCharacter('#');



    }


    @Override
    public void show() {
        batch=new SpriteBatch();

        buttonRegister=new TextButton("Don't have an Account ?",skin);
        buttonRegister.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                game.setScreen(new RegisterScreen(game));
            }
        });
        table.setWidth(Gdx.graphics.getWidth());
        table.align(Align.left | Align.top);
        table.setPosition(150, (Gdx.graphics.getHeight() / 2) + 60);
        table.add(textEmail).size(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 12);
        table.row();
        table.add(textPassword).size(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 12);
        table.row();
        table.add(buttonLogin).size(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 12);
        table.row();
        table.add(buttonRegister).size(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/12);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
//        stage.addActor(buttonLogin);
//        stage.addActor(textEmail);
//        stage.addActor(textPassword);
        batch.setProjectionMatrix(camera.combined);
        bg=game.textures.loginScreenBG;

    }

    @Override
    public void render(float delta) {

        if(buttonClicked){
            if(buttonChanged){
                doSmtng();
                buttonClicked=false;
            } else {
                buttonChanged = true;
            }
        }

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

        Login packet = new Login();
        packet.mail = email;
        packet.password = password;

        game.network.client.sendTCP(packet);

        try {
            Thread.sleep(3000);
        } catch (Exception e){}


        System.out.println(password + " " + email);

        if(game.player.online){
            game.setScreen(new LobbyScreen(game));
        } else {
            buttonLogin.setText("Failed. Try Again.");
        }

    }
}
