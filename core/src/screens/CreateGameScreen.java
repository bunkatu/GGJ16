package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GGJ16;
import com.mygdx.game.Lobby;

import java.util.ArrayList;

import network.game.CreateGame;
import network.lobby.DeleteLobby;
import network.lobby.LeaveLobby;


public class CreateGameScreen implements Screen {
    ArrayList<String> connectedplayers = new ArrayList<String>();
    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Stage stage;
    private Table table,rightContainer,finalContainer,tableBottom;
    private Texture bg;
    private Skin skin;
    private ScrollPane scrollPane;
    private boolean isLobby=false;

    public CreateGameScreen(GGJ16 game){

        this.game = game;
        connectedplayers.add("osman");
        connectedplayers.add("ahmet");
        connectedplayers.add("john");
        connectedplayers.add("kutalmis");
        connectedplayers.add("zattirizopzop");
        connectedplayers.add("demonhunter");
        connectedplayers.add("crazyvillager");
        connectedplayers.add("harddemon123");
        connectedplayers.add("zenciportakal");

    }

    @Override
    public void show() {



        tableBottom = new Table();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        batch.setProjectionMatrix(camera.combined);
        skin=new Skin(Gdx.files.internal("uiskin.json"));
        Texture userImage=new Texture(Gdx.files.internal("imageTest.png"));//imagebutton ile profile gidebilir
        TextButton buttonstart,buttonQuit;
        buttonstart=new TextButton("Start Game",skin);
        buttonstart.addListener(new ClickListener()
        {
            public void clicked(InputEvent e, float x, float y)
            {
                CreateGame packet = new CreateGame();
                game.network.client.sendTCP(packet);
            }
        });
        buttonQuit=new TextButton("Quit",skin);
        buttonQuit.addListener(new ClickListener(){
                 @Override
                      public void clicked(InputEvent e, float x, float y)
                        {boolean as=false;
                           new Dialog("Some Dialog", skin, "dialog") {
                                protected void result (Object object) {
                                     System.out.println("Chosen: " + object);
                                          if(object.toString() == "true"){
                                              DeleteLobby packet=new DeleteLobby();
                                              game.network.client.sendTCP(packet);
                                          }
                                           }
                      }.text("Are you sure you want to quit?").button("Yes", true).button("No",false).key(Input.Keys.ENTER,true)
                          .key(Input.Keys.ESCAPE,false).show(stage);
                        }
            });
        bg = game.textures.createGameScreenBG;
        tableBottom.add(buttonstart).size(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() * 0.3f);
        tableBottom.add(buttonQuit).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()*0.3f);
        rightContainer=new Table();
        rightContainer.add(new Image(userImage)).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() * (0.7f));
        rightContainer.row();
        rightContainer.add(tableBottom);
        stage=new Stage(new ScreenViewport());
        table=new Table();
        table.align(Align.left | Align.top);
        bg = game.textures.lobbyScreenBG;
        for(final String players:connectedplayers){
            TextButton buttoni=new TextButton(players.toString(),skin);
            buttoni.getLabel().setFontScale(3.5f);
            buttoni.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent e, float x, float y) {
                    System.out.println("Basıldı: "+players.toString());
                }
            });
            table.add(buttoni).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
            table.row();
        }
        scrollPane=new ScrollPane(table);
        scrollPane.setWidth(Gdx.graphics.getWidth());
        scrollPane.setHeight(Gdx.graphics.getHeight());
        finalContainer=new Table();
        finalContainer.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        finalContainer.add(scrollPane).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        finalContainer.add(rightContainer).size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        stage.addActor(finalContainer);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(game.gameState.active){
            game.setScreen(new GameScreen(game));
        }

        for (Lobby l:game.lobbies){
            if (l.players.contains(game.player.username)){
                isLobby=true;
            }

        }
        if(!isLobby&&!game.gameState.active){
            game.setScreen(new LobbyScreen(game));
        }
        isLobby=false;

        camera.update();
        batch.begin();
        batch.draw(bg, 0, 0);
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
