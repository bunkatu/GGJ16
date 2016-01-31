package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GGJ16;
import com.mygdx.game.Player;

import java.util.Map;

public class GameScreen implements Screen {

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private BitmapFont font;
    Skin skin;

    private Texture bg;


    public GameScreen(GGJ16 game){
        this.game = game;
    }

    @Override
    public void show() {

        skin =new Skin(Gdx.files.internal("uiskin.json"));
        font=new BitmapFont();
        System.out.println(game.gameState.id);
        for (String name:game.gameState.players){
            System.out.println(name);
        }
//        for (String name:game.gameState.roles){
//            System.out.println(name);
//        }
        System.out.println(game.gameState.demon);
        System.out.println(game.gameState.turn);
        for(Map.Entry<String,Integer> entry: game.gameState.votes.entrySet()){
            System.out.println(entry.getKey()+"/"+entry.getValue());
        }


        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        batch.setProjectionMatrix(camera.combined);

        bg = game.textures.gameScreenBG;

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(bg, 0, 0);
        System.out.println(game.gameState.playerTypes.size());
        for(int i=0;i<game.gameState.playerTypes.size();i++){
            Player player=game.gameState.playerTypes.get(i);
            int type=player.type;
            if(type==0){
                font.draw(batch,player.username,i*150,i*150);
                batch.draw(game.textures.kiz_burunlar.get(0),150*i,150*i);
                batch.draw(game.textures.kiz_dudaklar.get(player.lips),150*i,150*i);
                batch.draw(game.textures.kiz_elbiseler.get(player.dress),150*i,150*i);
                batch.draw(game.textures.kiz_gozler.get(player.eyes),150*i,150*i);
                batch.draw(game.textures.kiz_kaslar.get(player.eyebrows),150*i,150*i);
                batch.draw(game.textures.kiz_saclar.get(player.hair),150*i,150*i);
            }


        }

        camera.update();


        batch.end();

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
