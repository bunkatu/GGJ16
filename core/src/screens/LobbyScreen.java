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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GGJ16;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.mygdx.game.Lobby;

import java.util.ArrayList;

import network.lobby.CreateLobby;
import network.lobby.JoinLobby;
import network.lobby.LeaveLobby;


public class LobbyScreen implements Screen {

    ArrayList<Lobby> createdLobbies=new ArrayList<Lobby>();
    ArrayList<TextButton> lobbyButtons=new ArrayList<TextButton>();


    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Stage stage;
    private Table table,rightContainer,finalContainer,tableBottom;
    private Skin skin;
    private ScrollPane scrollPane;

    private Texture bg;
    private boolean renderLobbyList = true;


    public LobbyScreen(GGJ16 game){

        this.game = game;
//        String info="No:1    Oyun1    6/8";
//        createdGames.add(info);
//        createdGames.add("No:2 \t\t\t Oyun2 \t 3/5");
//        createdGames.add("No:3 \t\t\t Oyun3 \t 4/8");
//        createdGames.add("No:4 \t\t\t Oyun4 \t 7/8");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");
//        createdGames.add("No:5 \t\t\t Oyun5 \t 6/7");

    }

    @Override
    public void show() {


//        for (int i=0;i<game.lobbyList.games.size();i++) {
//            String name=game.lobbyList.games.get(i).name;
//            int id=game.lobbyList.games.get(i).id;
//            int attend=game.lobbyList.games.get(i).players.size();
//
//            createdGames.add(Integer.toString(id)+"     "+name+"     "+attend+"/8");
//            game.lobbyList.games.remove(i);
//        }


        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        batch.setProjectionMatrix(camera.combined);

        skin=new Skin(Gdx.files.internal("uiskin.json"));


        Texture userImage=new Texture(Gdx.files.internal("imageTest.png"));
        tableBottom=new Table();
        TextButton buttonCreate,buttonQuit;
        buttonCreate=new TextButton("Create Game",skin);
        buttonCreate.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                CreateLobby packet=new CreateLobby();
                game.network.client.sendTCP(packet);
            }
        });
        buttonQuit=new TextButton("Quit",skin);
        buttonQuit.addListener(new ClickListener() {
                                   @Override
                                   public void clicked(InputEvent e, float x, float y) {
                                       boolean as = false;
                                       new Dialog("Some Dialog", skin, "dialog") {
                                           protected void result(Object object) {
                                               System.out.println("Chosen: " + object);
                                               if (object.toString() == "true"){
                                                   System.exit(0);
                                               }

                                           }
                                       }.text("Are you sure you want to quit?").button("Yes", true).button("No", false).key(Input.Keys.ENTER, true)
                                               .key(Input.Keys.ESCAPE, false).show(stage);

                                   }
                               }
        );
        tableBottom.add(buttonCreate).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()*0.3f);
        tableBottom.add(buttonQuit).size(Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()*0.3f);
        rightContainer=new Table();
        Image image=new Image(userImage);
        rightContainer.add(image).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() * (0.6f));
        rightContainer.row();
        TextButton customizeButton=new TextButton("Customize Your Character!",skin);
        customizeButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent e, float x, float y){
                game.setScreen(new CustomizeScreen(game));
            }
        });
        rightContainer.add(customizeButton).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() * 0.1f);
        rightContainer.row();
        rightContainer.add(tableBottom);

        stage=new Stage(new ScreenViewport());
        table=new Table();
        table.align(Align.left|Align.top);
        bg = game.textures.lobbyScreenBG;
        createdLobbies.addAll(game.lobbies);
        for(final Lobby gamecreated:createdLobbies){
            TextButton buttoni=new TextButton(gamecreated.name,skin);
            buttoni.getLabel().setFontScale(3.5f);
            buttoni.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent e, float x, float y) {
                    System.out.println("Basıldı: " + gamecreated.toString());

                    JoinLobby packet = new JoinLobby();
                    packet.id = gamecreated.id;
                    game.network.client.sendTCP(packet);
//                    game.setScreen(new JoinGameScreen(game)); //TODO gameismini arguman olarak yolla

                }
            });

            lobbyButtons.add(buttoni);
//            table.add(buttoni).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
//            table.row();
        }

        for (TextButton bt:lobbyButtons){
            table.add(bt).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
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




        if(!createdLobbies.equals(game.lobbies)){
            for (int i=0;i<createdLobbies.size();i++){
                if (!game.lobbies.contains(createdLobbies.get(i))){
                    createdLobbies.remove(i);
                    table.removeActor(lobbyButtons.get(i),true);
                    lobbyButtons.remove(i);
                }
            }
            for (int i=0;i<game.lobbies.size();i++){
                if (!createdLobbies.contains(game.lobbies.get(i))){
                    final Lobby lobby=game.lobbies.get(i);
                    createdLobbies.add(lobby);
                    TextButton buttoni=new TextButton(lobby.name,skin);
                    buttoni.getLabel().setFontScale(3.5f);
                    buttoni.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent e, float x, float y) {
                            System.out.println("Basıldı: " + lobby.name);
                            JoinLobby packet = new JoinLobby();
                            packet.id = lobby.id;
                            game.network.client.sendTCP(packet);

//                    game.setScreen(new JoinGameScreen(game)); //TODO gameismini arguman olarak yolla

                        }
                    });
                    lobbyButtons.add(buttoni);
                    table.add(buttoni).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 10);
                    table.row();

                }
            }
        }
        for(Lobby lobby :game.lobbies){
//            System.out.print("Test1");
            if (lobby.players.get(0).equals(game.player.username)){
//                System.out.print("Test2");
                game.setScreen(new CreateGameScreen(game,lobby));
            }
            else if(lobby.players.contains(game.player.username)){
//                System.out.print("Test3");
                game.setScreen(new JoinGameScreen(game,lobby));
            }
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        table.clear();
//        System.out.println("Lobbies size: " +game.lobbies.size());

//        for(Lobby lobby:game.lobbies){
//
//            String info=lobby.id+"      "+lobby.name+"      "+lobby.players.size()+"/"+lobby.size;
//            createdGames.add(new Lobby());
//            TextButton buttoni=new TextButton(info,skin);
//            buttoni.getLabel().setFontScale(3f);
//            buttoni.addListener(new ClickListener() {
//                @Override
//                public void clicked(InputEvent e, float x, float y) {
//                    game.setScreen(new JoinGameScreen(game));
//                }
//            });
//            table.add(buttoni).size(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 10);
//            table.row();
//        }

        camera.update();
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.end();
        stage.act(delta);
        stage.draw();

//        if(game.lobbies.size() != 0){
//            String name=game.lobbies.get();
//            int id=game.lobbyList.games.get(0).id;
//            int attend=game.lobbyList.games.get(0).players.size();
//            String info=id+"     "+name+"     "+attend+"/8";
//            createdGames.add(info);
//            TextButton buttoni=new TextButton(info,skin);
//            buttoni.getLabel().setFontScale(3.5f);
//            buttoni.addListener(new ClickListener(){
//                @Override
//                public void clicked(InputEvent e, float x, float y) {
//                    game.setScreen(new JoinGameScreen(game)); //TODO gameismini arguman olarak yolla
//
//                }
//            });
//            table.add(buttoni).size(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 10);
//            table.row();
//            game.lobbyList.games.remove(0);
//
//        }

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
