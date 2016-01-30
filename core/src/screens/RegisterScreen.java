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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GGJ16;

import network.Register;

/**
 * Created by alimgiray on 29/01/16.
 */
public class RegisterScreen implements Screen {

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Texture bg;
    private TextField textUserName;
    private TextField textPassword;
    private TextField textEmail;
    private TextButton buttonRegister;
    private Skin skin;
    private Stage stage;
    private Table table;

    private boolean buttonClicked = false;
    private boolean buttonChanged = false;

    public RegisterScreen(GGJ16 game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        stage=new Stage(new ScreenViewport());
        table = new Table();



        skin=new Skin(Gdx.files.internal("uiskin.json"));
        buttonRegister=new TextButton("Register",skin);
        buttonRegister.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                buttonRegister.setText("Waiting Response..");
                buttonClicked = true;
            }
        });
//
        textUserName=new TextField("",skin);
        textUserName.setMessageText("UserName:");
        textPassword=new TextField("",skin);
        textPassword.setPasswordMode(true);
        textPassword.setPasswordCharacter('*');
        textPassword.setMessageText("Password:");
        textEmail=new TextField("",skin);
        textEmail.setMessageText("Email:");



    }
    @Override
    public void show() {

        table.setWidth(stage.getWidth());
        table.align(Align.center | Align.top);
        table.setPosition(0, (Gdx.graphics.getHeight()/2)+120);
        table.add(textUserName).size(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight() / 12);
        table.row();
        table.add(textEmail).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/12);
        table.row();
        table.add(textPassword).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/12);
        table.row();
        table.add(buttonRegister).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/12);

        batch=new SpriteBatch();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
        batch.setProjectionMatrix(camera.combined);
        bg=game.textures.registerScreenBG;
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
        String username = textUserName.getText();
        String password = textPassword.getText();
        String email = textEmail.getText();

        Register packet = new Register();
        packet.mail = email;
        packet.username = username;
        packet.password = password;
        game.network.client.sendTCP(packet);

        try {
            Thread.sleep(3000);
        } catch (Exception e){}

        System.out.println(username + " " + password + " " + email);


        if (game.player.is_registered){
            game.setScreen(new LoginScreen(game));
        }
        else {
            buttonRegister.setText("Failed. Try Again.");
        }

    }

}
