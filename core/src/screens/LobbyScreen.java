package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GGJ16;

import java.util.ArrayList;

public class LobbyScreen implements Screen {

    ArrayList<String> createdGames=new ArrayList<String>();

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Stage stage;
    private Table table,tableUser,rightContainer,finalContainer,tableBottom,container,tableNo,tableName,tableAtt;
    private Skin skin;
    private ScrollPane scrollPane;

    private Texture bg;


    public LobbyScreen(GGJ16 game){

        this.game = game;
        String info="No:1    Oyun1    6/8";
        createdGames.add(info);
        createdGames.add("No:2 \t\t\t Oyun2 \t 3/5");
        createdGames.add("No:3 \t\t\t Oyun3 \t 4/8");
        createdGames.add("No:4 \t\t\t Oyun4 \t 7/8");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        batch.setProjectionMatrix(camera.combined);

        skin=new Skin(Gdx.files.internal("uiskin.json"));


        Texture userImage=new Texture(Gdx.files.internal("imageTest.png"));
        tableBottom=new Table();
        TextButton buttonCreate,buttonQuit;
        buttonCreate=new TextButton("Create Game",skin);
        buttonQuit=new TextButton("Quit",skin);
        tableBottom.add(buttonCreate).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()*0.3f);
        tableBottom.add(buttonQuit).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()*0.3f);
        rightContainer=new Table();
        rightContainer.add(new Image(userImage)).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()*(0.7f));
        rightContainer.row();
        rightContainer.add(tableBottom);



        stage=new Stage(new ScreenViewport());
        table=new Table();
        table.align(Align.left|Align.top);
        bg = game.textures.lobbyScreenBG;
        for(final String gamecreated:createdGames){
            TextButton buttoni=new TextButton(gamecreated.toString(),skin);
            buttoni.getLabel().setFontScale(3.5f);
            buttoni.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent e, float x, float y) {
                    System.out.println("Basıldı: "+gamecreated.toString());
                }
            });
            table.add(buttoni).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
            table.row();
        }

        scrollPane=new ScrollPane(table);
        scrollPane.setWidth(Gdx.graphics.getWidth());
        scrollPane.setHeight(Gdx.graphics.getHeight());
        scrollPane.setSmoothScrolling(true);
        finalContainer=new Table();
        finalContainer.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        finalContainer.add(scrollPane).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        finalContainer.add(rightContainer).size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        stage.addActor(finalContainer);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.begin();
        batch.draw(bg, 0,0);
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
}
