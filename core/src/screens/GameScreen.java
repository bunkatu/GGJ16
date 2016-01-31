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

import java.util.ArrayList;
import java.util.Map;

public class GameScreen implements Screen {

    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private BitmapFont font;
    private static float POS1X;
    private static float POS1Y;
    private static float POS2X;
    private static float POS2Y;
    private static float POS3X;
    private static float POS3Y;
    private static float POS4X;
    private static float POS4Y;
    private static float POS5X;
    private static float POS5Y;
    private static float POS6X;
    private static float POS6Y;
    ArrayList<Float> posx;
    ArrayList<Float> posy;

    Skin skin;

    private Texture bg;


    public GameScreen(GGJ16 game){
        this.game = game;
    }

    @Override
    public void show() {

        skin =new Skin(Gdx.files.internal("uiskin.json"));
        font=new BitmapFont();
        font.setColor(0,0,0,1);
        POS1X=(Gdx.graphics.getWidth()*2/6);
        POS1Y=0;
        POS2X=(Gdx.graphics.getWidth()*2/8);
        POS2Y=(Gdx.graphics.getHeight()*0.4f);
        POS3X=(Gdx.graphics.getWidth()*3/10);
        POS3Y=(Gdx.graphics.getHeight()*0.5f);
        POS4X=(Gdx.graphics.getWidth()*6/10);
        POS4Y=(Gdx.graphics.getHeight()*0.5f);
        POS5X=(Gdx.graphics.getWidth()*5/8);
        POS5Y=(Gdx.graphics.getHeight()*0.4f);
        POS6X=(Gdx.graphics.getWidth()*3/6);
        POS6Y=0;
        posx=new ArrayList<Float>();
        posx.add(POS1X);
        posx.add(POS2X);
        posx.add(POS3X);
        posx.add(POS4X);
        posx.add(POS5X);
        posx.add(POS6X);
        posy=new ArrayList<Float>();
        posy.add(POS1Y);
        posy.add(POS2Y);
        posy.add(POS3Y);
        posy.add(POS4Y);
        posy.add(POS5Y);
        posy.add(POS6Y);

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

        float scale=200;

        batch.begin();
        batch.draw(bg, 0, 0);
        System.out.println(game.gameState.playerTypes.size());
        for(int i=0;i<game.gameState.playerTypes.size();i++){
            if (i==1||i==6){
                scale=(Gdx.graphics.getWidth()*0.6f);
            }
            else if (i==2||i==5){
                scale=(Gdx.graphics.getWidth()*0.5f);
            }
            else if (i==3||i==4){
                scale=(Gdx.graphics.getWidth()*0.4f);
            }
            Player player=game.gameState.playerTypes.get(i);
            int type=player.type;
            if(type==0){
//                System.out.println(game.gameState.players.size()+"xsize"+posx.size()+"ysize"+posy.size());
                font.draw(batch,game.gameState.players.get(i),posx.get(i),posy.get(i));
                System.out.println("Eleman : " + game.gameState.players.get(i));

                batch.draw(game.textures.kiz_tenler.get(player.skin),posx.get(i),posy.get(i),scale,scale);
                batch.draw(game.textures.kiz_burunlar.get(0),posx.get(i),posy.get(i),scale,scale);
                batch.draw(game.textures.kiz_dudaklar.get(player.lips),posx.get(i),posy.get(i),scale,scale);
                batch.draw(game.textures.kiz_elbiseler.get(player.dress),posx.get(i),posy.get(i),scale,scale);
                batch.draw(game.textures.kiz_gozler.get(player.eyes),posx.get(i),posy.get(i),scale,scale);
                batch.draw(game.textures.kiz_kaslar.get(player.eyebrows),posx.get(i),posy.get(i),scale,scale);
                batch.draw(game.textures.kiz_saclar.get(player.hair),posx.get(i),posy.get(i),scale,scale);

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
