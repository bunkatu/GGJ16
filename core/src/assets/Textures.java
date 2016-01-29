package assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Textures {

    public Texture loadingScreenBG;
    public Texture gameScreenBG;
    public Texture createGameScreenBG;
    public Texture joinGameScreenBG;
    public Texture lobbyScreenBG;
    public Texture loginScreenBG;
    public Texture registerScreenBG;

    public Textures(){

    }

    public void loadBG(){
        gameScreenBG = new Texture(Gdx.files.internal("screens/gameScreenBG.jpg"));
        createGameScreenBG = new Texture(Gdx.files.internal("screens/createGameScreenBG.jpg"));
        joinGameScreenBG = new Texture(Gdx.files.internal("screens/joinGameScreenBG.jpg"));
        lobbyScreenBG = new Texture(Gdx.files.internal("screens/lobbyScreenBG.jpg"));
        loginScreenBG = new Texture(Gdx.files.internal("screens/loginScreenBG.jpg"));
        registerScreenBG = new Texture(Gdx.files.internal("screens/registerScreenBG.jpg"));

    }

}
