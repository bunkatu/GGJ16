package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GGJ16;

import java.util.ArrayList;

import javax.xml.soap.Text;

/**
 * Created by kullanici on 30.01.2016.
 */
public class CustomizeScreen implements Screen {
    GGJ16 game;
    public OrthographicCamera camera;
    public SpriteBatch batch;
    private Texture bg;
    private Texture sac;
    private Texture elbise;
    private Texture ten;
    private Texture dudak;
    private Texture kas;
    private Texture goz;
    private Texture burun;
    private Texture gomlek,ayakkabi;
    private Texture gozluk,biyik,kolye;
    private TextButton buttonAmca,buttonTeyze;
    private Stage stage;
    private Table tableCategories,mainHolder,charContainer;
    private TextButton prev,next;
    private ScrollPane scrollPane;
    private Skin skin;
    private ArrayList<String> categories;
    Texture skingirl,dress;
    static int selection=0;
    static int currentChar=0;
    static boolean amcaCheck=true,teyzeCheck = false;


    public CustomizeScreen(GGJ16 game){
        this.game=game;
        batch = new SpriteBatch();
        camera=new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        stage=new Stage(new ScreenViewport());
        bg = game.textures.lobbyScreenBG;
        tableCategories=new Table();
        tableCategories.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        tableCategories.align(Align.left);
        categories=new ArrayList<String>();

        categories.add("Hair");
        categories.add("Eyes");
        categories.add("Lips");
        categories.add("Skin");
        categories.add("Dress");
        categories.add("Eyebrows");
    }
    @Override
    public void show() {

        skin=new Skin(Gdx.files.internal("uiskin.json"));

        buttonAmca=new TextButton("Gomlek",skin);

        buttonTeyze = new TextButton("Kolye",skin);

        for (int i=0; i<categories.size(); i++){
            final int sel=i;
            TextButton buttoni=new TextButton(categories.get(i),skin);
            buttoni.getLabel().setFontScale(3f);
            buttoni.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent e, float x, float y) {
                    selection = sel;
                    if(currentChar==0){
                        kizNext(selection);
                    }
                    else if(currentChar==1){
                        erkekNext(selection);
                    }
                    else if(currentChar==2){
                        amcaNext(selection);
                    }
                    else if(currentChar==3){
                        teyzeNext(selection);
                    }
                    System.out.println("Selection: "+selection);
                }
            });
            tableCategories.add(buttoni).fillX();
            tableCategories.row();

        }
        scrollPane=new ScrollPane(tableCategories);
        scrollPane.setWidth(Gdx.graphics.getWidth());
        scrollPane.setHeight(Gdx.graphics.getHeight());
        mainHolder=new Table();
        mainHolder.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        mainHolder.align(Align.left);
        mainHolder.add(scrollPane).size(Gdx.graphics.getWidth() * 0.3f, Gdx.graphics.getHeight());
//        charContainer=new Table();
//        charContainer.setSize(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight());
        prev=new TextButton("Previous!",skin);
        prev.setPosition(Gdx.graphics.getWidth()*0,8,10);
        next=new TextButton("Next!",skin);
        next.setPosition(Gdx.graphics.getWidth()*0,9,10);
        prev.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                //TODO
                System.out.println("Previous pressed!!");
                currentChar=(currentChar+3)%4;
                if (currentChar==0){
                    kizInitial();
                }
                else if (currentChar==1){
                    erkekInitial();
                }
                else if(currentChar==2){
                    amcaIntiial();
                }
                else if(currentChar==3){
                    teyzeInitial();
                }
            }
        });
        next.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {

                System.out.println("Next pressed!!");
                currentChar=(currentChar+1)%4;
                if (currentChar==0){
                    kizInitial();
                }
                else if (currentChar==1){
                    erkekInitial();
                }
                else if(currentChar==2){
                    amcaIntiial();
                }
                else if(currentChar==3){
                    teyzeInitial();
                }

            }
        });

        kizInitial();

//        charContainer.add(skingirl);
//        charContainer.add(dress).fillX().fillY();

//        charContainer.add();
        mainHolder.add(prev).size(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/10);
//        mainHolder.add(charContainer);
        mainHolder.add(next).size(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 10);

        stage.addActor(mainHolder);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.draw(ten,700,100);
        batch.draw(dudak,700,100);
        batch.draw(sac,700,100);
        batch.draw(goz,700,100);
        batch.draw(kas,700,100);
        batch.draw(burun,700,100);
        if(currentChar == 1||currentChar==2)
        {
            batch.draw(ayakkabi,700,100);
            batch.draw(gomlek,700,100);
        }
        if(currentChar==2){
            batch.draw(gozluk, 700, 100);
            batch.draw(biyik,700,100);
            if(amcaCheck) {
                buttonAmca.getLabel().setFontScale(3f);
                buttonAmca.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent e, float x, float y) {
                        if(currentChar == 2)
                        {  amcaNext(6);
                        System.out.println("Selection: "+6);}
                    }
                });
                tableCategories.add(buttonAmca).fillX();
                tableCategories.row();

                amcaCheck = false;
            }
            else{
                buttonAmca.setVisible(true);
            }
        }
        else{
                buttonAmca.setVisible(false);
                amcaCheck=true;
        }
        if(currentChar==3) {

            batch.draw(game.textures.teyze_tisort,700,100);
            batch.draw(ayakkabi,700,100);
            batch.draw(gomlek,700,100);



        }
        batch.draw(elbise,700,100);
        if(currentChar == 3)
        {

            batch.draw(kolye,700,100);
        }

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

    public void kizNext(int selection){
        if (selection == 0) {
            int index = game.textures.kiz_saclar.indexOf(sac);
            sac = game.textures.kiz_saclar.get((index + 1) % game.textures.kiz_saclar.size());
        } else if (selection == 1) {
            int index = game.textures.kiz_gozler.indexOf(goz);
            goz = game.textures.kiz_gozler.get((index + 1) % game.textures.kiz_gozler.size());
        } else if (selection == 2) {
            int index = game.textures.kiz_dudaklar.indexOf(dudak);
            dudak=game.textures.kiz_dudaklar.get((index+1)%game.textures.kiz_dudaklar.size());
        }else if (selection == 3) {
            int index = game.textures.kiz_tenler.indexOf(ten);
            ten=game.textures.kiz_tenler.get((index+1)%game.textures.kiz_tenler.size());
        }else if (selection == 4) {
            int index = game.textures.kiz_elbiseler.indexOf(elbise);
            elbise=game.textures.kiz_elbiseler.get((index+1)%game.textures.kiz_elbiseler.size());
        }else if (selection == 5) {
            int index = game.textures.kiz_kaslar.indexOf(kas);
            kas=game.textures.kiz_kaslar.get((index+1)%game.textures.kiz_kaslar.size());
        }
    }


    public void kizInitial(){
        dudak=game.textures.kiz_dudaklar.get(0);
        ten=game.textures.kiz_tenler.get(0);
        sac=game.textures.kiz_saclar.get(0);
        kas=game.textures.kiz_kaslar.get(0);
        goz=game.textures.kiz_gozler.get(0);
        elbise=game.textures.kiz_elbiseler.get(0);
        burun = game.textures.kiz_burun;
    }

    public void erkekNext(int selection){
        if (selection == 0) {
            int index = game.textures.erkek_saclar.indexOf(sac);
            sac = game.textures.erkek_saclar.get((index + 1) % game.textures.erkek_saclar.size());
        } else if (selection == 1) {
            int index = game.textures.erkek_gozler.indexOf(goz);
            goz = game.textures.erkek_gozler.get((index + 1) % game.textures.erkek_gozler.size());
        } else if (selection == 2) {
            int index = game.textures.erkek_dudaklar.indexOf(dudak);
            dudak=game.textures.erkek_dudaklar.get((index+1)%game.textures.erkek_dudaklar.size());
        }else if (selection == 3) {
            int index = game.textures.erkek_tenler.indexOf(ten);
            ten=game.textures.erkek_tenler.get((index+1)%game.textures.erkek_tenler.size());
        }else if (selection == 4) {
            int index = game.textures.erkek_pantolonlar.indexOf(elbise);
            elbise=game.textures.erkek_pantolonlar.get((index+1)%game.textures.erkek_pantolonlar.size());
        }else if (selection == 5) {
            int index = game.textures.erkek_kaslar.indexOf(kas);
            kas=game.textures.erkek_kaslar.get((index+1)%game.textures.erkek_kaslar.size());
        }

    }
    public void erkekInitial(){
        dudak=game.textures.erkek_dudaklar.get(0);
        ten=game.textures.erkek_tenler.get(0);
        sac=game.textures.erkek_saclar.get(0);
        burun=game.textures.erkek_burun;
        goz=game.textures.erkek_gozler.get(0);
        elbise=game.textures.erkek_pantolonlar.get(0);
        gomlek = game.textures.erkek_gomlek;
        ayakkabi = game.textures.erkek_ayakkabi;
        kas=game.textures.erkek_kaslar.get(0);
    }

    public void amcaNext(int selection){
        if (selection == 0) {
            sac = game.textures.amca_sac;
        } else if (selection == 1) {
            int index = game.textures.amca_gozler.indexOf(goz);
            goz = game.textures.amca_gozler.get((index + 1) % game.textures.amca_gozler.size());
        } else if (selection == 2) {
            int index = game.textures.amca_dudaklar.indexOf(dudak);
            dudak=game.textures.amca_dudaklar.get((index+1)%game.textures.amca_dudaklar.size());
        }else if (selection == 3) {
            int index = game.textures.amca_tenler.indexOf(ten);
            ten=game.textures.amca_tenler.get((index+1)%game.textures.amca_tenler.size());
        }else if (selection == 4) {
            int index = game.textures.amca_pantolonlar.indexOf(elbise);
            elbise=game.textures.amca_pantolonlar.get((index+1)%game.textures.amca_pantolonlar.size());
        }else if (selection == 5) {
            int index = game.textures.amca_kaslar.indexOf(kas);
            kas=game.textures.amca_kaslar.get((index+1)%game.textures.amca_kaslar.size());
        }
        else if (selection == 6) {
            int index = game.textures.amca_tisortler.indexOf(gomlek);
            gomlek=game.textures.amca_tisortler.get((index+1)%game.textures.amca_tisortler.size());
        }

    }
    public void amcaIntiial(){
        dudak=game.textures.amca_dudaklar.get(0);
        ten=game.textures.amca_tenler.get(0);
        sac=game.textures.amca_sac;
        burun=game.textures.amca_burun;
        goz=game.textures.amca_gozler.get(0);
        elbise=game.textures.amca_pantolonlar.get(0);
        ayakkabi=game.textures.amca_ayakkabi;
        gomlek=game.textures.amca_tisortler.get(0);
        gozluk=game.textures.amca_gozluk;
        biyik=game.textures.amca_biyik;
        kas=game.textures.amca_kaslar.get(0);




    }
    public void teyzeNext(int selection){

        if (selection == 0) {
            int index = game.textures.teyze_saclar.indexOf(sac);
            sac = game.textures.teyze_saclar.get((index + 1) % game.textures.teyze_saclar.size());
        } else if (selection == 1) {
            goz = game.textures.teyze_goz;
        } else if (selection == 2) {
            int index = game.textures.teyze_dudaklar.indexOf(dudak);
            dudak=game.textures.teyze_dudaklar.get((index+1)%game.textures.teyze_dudaklar.size());
        }else if (selection == 3) {
            int index = game.textures.teyze_tenler.indexOf(ten);
            ten=game.textures.teyze_tenler.get((index+1)%game.textures.teyze_tenler.size());
        }else if (selection == 4) {
            int index = game.textures.teyze_tisortler.indexOf(elbise);
            elbise=game.textures.teyze_tisortler.get((index+1)%game.textures.teyze_tisortler.size());
        }else if (selection == 5) {
            int index = game.textures.teyze_kolyeler.indexOf(kas);
            kas=game.textures.teyze_kolyeler.get((index+1)%game.textures.teyze_kolyeler.size());
        }
    }
    public void teyzeInitial(){
        dudak=game.textures.teyze_dudaklar.get(0);
        ten=game.textures.teyze_tenler.get(0);
        sac=game.textures.teyze_saclar.get(0);
        burun=game.textures.teyze_burun;
        goz=game.textures.teyze_goz;
        elbise=game.textures.teyze_tisortler.get(0);
        ayakkabi=game.textures.teyze_ayakkabi;
        gomlek=game.textures.teyze_etek;
        gozluk=game.textures.teyze_gozluk;
        kolye=game.textures.teyze_kolyeler.get(0);
    }

}
