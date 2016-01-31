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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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

import network.lobby.LeaveLobby;
import network.lobby.LobbyReady;

public class JoinGameScreen implements Screen {

    ArrayList<String> lobbyPlayers=new ArrayList<String>();
    ArrayList<TextButton> playerButtons = new ArrayList<TextButton>();

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Stage stage;
    private Table table,rightContainer,finalContainer,tableBottom;
    private Skin skin;
    private ScrollPane scrollPane;
    private Texture bg;
    private Lobby thisLobby;


    public JoinGameScreen(GGJ16 game, Lobby l){
        this.game = game;
        this.thisLobby=l;
//        otherplayers.add("host");
//        otherplayers.add("john");
//        otherplayers.add("kutalmis");
//        otherplayers.add("zattirizopzop");
//        otherplayers.add("demonhunter");
//        otherplayers.add("crazyvillager");
//        otherplayers.add("harddemon123");
//        otherplayers.add("zenciportakal");

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
        final TextButton readyButton,buttonQuit;
        readyButton=new TextButton("Ready",skin);
        readyButton.addListener(new ClickListener()
        {
            public void clicked(InputEvent e, float x, float y)
            {
                LobbyReady packet = new LobbyReady();
                game.network.client.sendTCP(packet);
                readyButton.setDisabled(true);


//                game.setScreen(new LobbyScreen(game));
            }
        });
        buttonQuit=new TextButton("Leave Lobby",skin);
        buttonQuit.addListener(new ClickListener() {
                                   @Override
                                   public void clicked(InputEvent e, float x, float y) {
                                       boolean as = false;
                                       new Dialog("Some Dialog", skin, "dialog") {
                                           protected void result(Object object) {
                                               System.out.println("Chosen: " + object);
                                               if (object.toString() == "true") {
                                                   LeaveLobby packet = new LeaveLobby();
                                                   game.network.client.sendTCP(packet);
                                               }
                                           }
                                       }.text("Are you sure you want to quit?").button("Yes", true).button("No", false).key(Input.Keys.ENTER, true)
                                               .key(Input.Keys.ESCAPE, false).show(stage);

                                   }
                               }
        );
        tableBottom.add(readyButton).size(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() * 0.3f);
        tableBottom.add(buttonQuit).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()*0.3f);
        rightContainer=new Table();
        rightContainer.add(new Image(userImage)).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() * (0.7f));
        rightContainer.row();
        rightContainer.add(tableBottom);
        stage=new Stage(new ScreenViewport());
        table=new Table();
        table.align(Align.left|Align.top);
        bg = game.textures.joinGameScreenBG;
        lobbyPlayers.addAll(game.lobbies.get(game.lobbies.indexOf(thisLobby)).players);
        for(final String player:lobbyPlayers){
            TextButton buttoni=new TextButton(player,skin);
            buttoni.getLabel().setFontScale(3.5f);
            buttoni.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent e, float x, float y) {
                    System.out.println("Basıldı: " + player);
//                    game.setScreen(new JoinGameScreen(game)); //TODO gameismini arguman olarak yolla

                }
            });
            playerButtons.add(buttoni);
            table.add(buttoni).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
            table.row();
        }

        scrollPane=new ScrollPane(table);
        scrollPane.setWidth(Gdx.graphics.getWidth());
        scrollPane.setHeight(Gdx.graphics.getHeight());
        finalContainer=new Table();
        finalContainer.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        finalContainer.add(scrollPane).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        finalContainer.add(rightContainer).size(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        stage.addActor(finalContainer);
        bg=game.textures.joinGameScreenBG;
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {

        if(!game.lobbies.contains(thisLobby)){

            game.setScreen(new LobbyScreen(game));

            System.out.println("SICTIK ");
        }

        if(game.gameState.active){
            game.setScreen(new GameScreen(game));
        }
        try{
        if(!game.lobbies.get(game.lobbies.indexOf(thisLobby)).players.contains(game.player.username)){
            game.setScreen(new LobbyScreen(game));
        }}catch (Exception e)
        {
            System.out.print(e);
        }



        try {
            if(!lobbyPlayers.equals(game.lobbies.get(game.lobbies.indexOf(thisLobby)).players)){
                for (int i=0;i<lobbyPlayers.size();i++){
                    if(!game.lobbies.get(game.lobbies.indexOf(thisLobby)).players.contains(lobbyPlayers.get(i))){
                        lobbyPlayers.remove(i);
                        table.removeActor(playerButtons.get(i));
                        playerButtons.remove(i);
                    }
                }
                for (int i=0;i<game.lobbies.get(game.lobbies.indexOf(thisLobby)).players.size();i++){
                    if(!lobbyPlayers.contains(game.lobbies.get(game.lobbies.indexOf(thisLobby)).players.get(i))){
                        final String player=(game.lobbies.get(game.lobbies.indexOf(thisLobby)).players.get(i));
                        lobbyPlayers.add(player);
                        TextButton buttoni=new TextButton(player,skin);
                        buttoni.getLabel().setFontScale(3.5f);
                        buttoni.addListener(new ClickListener() {
                            @Override
                            public void clicked(InputEvent e, float x, float y) {
                                System.out.println("Basıldı: " + player);
//                    game.setScreen(new JoinGameScreen(game)); //TODO gameismini arguman olarak yolla

                            }
                        });
                        playerButtons.add(buttoni);
                        table.add(buttoni).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
                        table.row();

                    }
                }
            }
        }catch (Exception e){
            System.out.print("as");
        }




        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
