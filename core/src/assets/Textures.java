package assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Textures {

    public Texture loadingScreenBG;
    public Texture gameScreenBG;
    public Texture createGameScreenBG;
    public Texture joinGameScreenBG;
    public Texture lobbyScreenBG;
    public Texture loginScreenBG;
    public Texture registerScreenBG;
    public Texture customScreenBG;
    /*------------------kiz---------------*/
    public ArrayList<Texture> kiz_dudaklar;
    public ArrayList<Texture> kiz_tenler;
    public ArrayList<Texture> kiz_elbiseler;
    public ArrayList<Texture> kiz_gozler;
    public ArrayList<Texture> kiz_kaslar;
    public ArrayList<Texture> kiz_saclar;
    public ArrayList<Texture> kiz_burunlar;

    public Texture kiz_dudak1;
    public Texture kiz_dudak2;
    public Texture kiz_dudak3;
    public Texture kiz_dudak4;

    public Texture kiz_elbise_mavi;
    public Texture kiz_elbise_mor;
    public Texture kiz_elbise_sari;

    public Texture kiz_goz1;
    public Texture kiz_goz2;
    public Texture kiz_goz3;

    public Texture kiz_kas;
    public Texture kiz_kas1;
    public Texture kiz_kas2;

    public Texture kiz_sac_kizil;
    public Texture kiz_sac_kut;
    public Texture kiz_sac_sari;

    public Texture kiz_ten1;
    public Texture kiz_ten2;
    public Texture kiz_ten3;
    public Texture kiz_ten4;

    public Texture kiz_burun;

    /*------------------kiz---------------*/

    /*-----------------erkek--------------*/
    public ArrayList<Texture> erkek_dudaklar;
    public ArrayList<Texture> erkek_tenler;
    public ArrayList<Texture> erkek_pantolonlar;
    public ArrayList<Texture> erkek_gozler;
    public ArrayList<Texture> erkek_kaslar;
    public ArrayList<Texture> erkek_saclar;
    public ArrayList<Texture> erkek_ayakkabilar;
    public ArrayList<Texture> erkek_gomlekler;
    public ArrayList<Texture> erkek_burunlar;

    public Texture erkek_dudak1;
    public Texture erkek_dudak2;
    public Texture erkek_dudak3;

    public Texture erkek_burun;
    public Texture erkek_gomlek;
    public Texture erkek_ayakkabi;

    public Texture erkek_goz;
    public Texture erkek_goz1;
    public Texture erkek_goz2;

    public Texture erkek_pantolon;
    public Texture erkek_pantolon1;
    public Texture erkek_pantolon2;

    public Texture erkek_sac;
    public Texture erkek_sac1;
    public Texture erkek_sac2;

    public Texture erkek_ten;
    public Texture erkek_ten1;
    public Texture erkek_ten2;
    public Texture erkek_ten3;

    public Texture erkek_kas;
    public Texture erkek_kas1;
    public Texture erkek_kas2;
/*--------------erkek--------------*/
/* ------------Amca----------------*/
    public ArrayList<Texture> amca_tisortler;
    public ArrayList<Texture> amca_tenler;
    public ArrayList<Texture> amca_pantolonlar;
    public ArrayList<Texture> amca_gozler;
    public ArrayList<Texture> amca_kaslar;
    public ArrayList<Texture> amca_dudaklar;
    public ArrayList<Texture> amca_saclar;
    public ArrayList<Texture> amca_burunlar;
    public ArrayList<Texture> amca_ayakkabilar;
    public ArrayList<Texture> amca_gozlukler;

    public Texture amca_burun;
    public Texture amca_ayakkabi;
    public Texture amca_biyik;
    public Texture amca_dudak,amca_dudak1;
    public Texture amca_goz,amca_goz1;
    public Texture amca_gozluk;
    public Texture amca_kas,amca_kas1,amca_kas2;
    public Texture amca_pantolon,amca_pantolon1,amca_pantolon2;
    public Texture amca_sac;
    public Texture amca_ten,amca_ten1,amca_ten2;
    public Texture amca_tisort,amca_tisort1,amca_tisort2,amca_tisort3;
    /*-----------Amca---------------*/
    /*-----------Teyze-------------*/
    public ArrayList<Texture> teyze_tisortler;
    public ArrayList<Texture> teyze_tenler;
    public ArrayList<Texture> teyze_kolyeler;
    public ArrayList<Texture> teyze_saclar;
    public ArrayList<Texture> teyze_dudaklar;
    public ArrayList<Texture> teyze_kaslar;
    public ArrayList<Texture> teyze_gozler;
    public ArrayList<Texture> teyze_ayakkabilar;
    public ArrayList<Texture> teyze_gozlukler;
    public ArrayList<Texture> teyze_etekler;
    public ArrayList<Texture> teyze_burunlar;

    public Texture teyze_ayakkabi;
    public Texture teyze_burun;
    public Texture teyze_dudak,teyze_dudak1,teyze_dudak2;
    public Texture teyze_etek;
    public Texture teyze_goz;
    public Texture teyze_gozluk;
    public Texture teyze_kolye,teyze_kolye1,teyze_kolye2;
    public Texture teyze_sac,teyze_sac1,teyze_sac2;
    public Texture teyze_ten,teyze_ten1,teyze_ten2;
    public Texture teyze_tisort,teyze_tisort1,teyze_tisort2,teyze_tisort3;
    public Texture teyze_kas;

    /*---------------Teyze------------*/

    public Textures(){
        kiz_dudaklar=new ArrayList<Texture>();
        kiz_elbiseler=new ArrayList<Texture>();
        kiz_gozler=new ArrayList<Texture>();
        kiz_kaslar=new ArrayList<Texture>();
        kiz_saclar=new ArrayList<Texture>();
        kiz_tenler=new ArrayList<Texture>();
        kiz_burunlar=new ArrayList<Texture>();

        /*-----------------------------------------------------------*/
        kiz_dudak1=new Texture(Gdx.files.internal("kiz/kiz_dudak1.png"));
        kiz_dudak2=new Texture(Gdx.files.internal("kiz/kiz_dudak2.png"));
        kiz_dudak3=new Texture(Gdx.files.internal("kiz/kiz_dudak3.png"));
        kiz_dudak4=new Texture(Gdx.files.internal("kiz/kiz_dudak4.png"));

        kiz_elbise_mavi=new Texture(Gdx.files.internal("kiz/kiz_elbise_mavi.png"));
        kiz_elbise_mor=new Texture(Gdx.files.internal("kiz/kiz_elbise_mor.png"));
        kiz_elbise_sari=new Texture(Gdx.files.internal("kiz/kiz_elbise_sari.png"));

        kiz_goz1=new Texture(Gdx.files.internal("kiz/kiz_goz1.png"));
        kiz_goz2=new Texture(Gdx.files.internal("kiz/kiz_goz2.png"));
        kiz_goz3=new Texture(Gdx.files.internal("kiz/kiz_goz3.png"));

        kiz_kas=new Texture(Gdx.files.internal("kiz/kiz_kas.png"));
        kiz_kas1=new Texture(Gdx.files.internal("kiz/kiz_kas1.png"));
        kiz_kas2=new Texture(Gdx.files.internal("kiz/kiz_kas2.png"));

        kiz_sac_kizil=new Texture(Gdx.files.internal("kiz/kiz_sac_kizil.png"));
        kiz_sac_kut=new Texture(Gdx.files.internal("kiz/kiz_sac_kut.png"));
        kiz_sac_sari=new Texture(Gdx.files.internal("kiz/kiz_sac_sari.png"));

        kiz_ten1=new Texture(Gdx.files.internal("kiz/kiz_ten1.png"));
        kiz_ten2=new Texture(Gdx.files.internal("kiz/kiz_ten2.png"));
        kiz_ten3=new Texture(Gdx.files.internal("kiz/kiz_ten3.png"));
        kiz_ten4=new Texture(Gdx.files.internal("kiz/kiz_ten4.png"));

        kiz_burun = new Texture(Gdx.files.internal("kiz/kiz_burun.png"));

        kiz_burunlar.add(kiz_burun);

        kiz_dudaklar.add(kiz_dudak1);
        kiz_dudaklar.add(kiz_dudak2);
        kiz_dudaklar.add(kiz_dudak3);
        kiz_dudaklar.add(kiz_dudak4);

        kiz_elbiseler.add(kiz_elbise_mavi);
        kiz_elbiseler.add(kiz_elbise_mor);
        kiz_elbiseler.add(kiz_elbise_sari);

        kiz_gozler.add(kiz_goz1);
        kiz_gozler.add(kiz_goz2);
        kiz_gozler.add(kiz_goz3);

        kiz_kaslar.add(kiz_kas);
        kiz_kaslar.add(kiz_kas1);
        kiz_kaslar.add(kiz_kas2);

        kiz_saclar.add(kiz_sac_kizil);
        kiz_saclar.add(kiz_sac_kut);
        kiz_saclar.add(kiz_sac_sari);

        kiz_tenler.add(kiz_ten1);
        kiz_tenler.add(kiz_ten2);
        kiz_tenler.add(kiz_ten3);
        kiz_tenler.add(kiz_ten4);

       /*------------------------------------------------ */
        erkek_dudaklar=new ArrayList<Texture>();
        erkek_tenler=new ArrayList<Texture>();
        erkek_pantolonlar=new ArrayList<Texture>();
        erkek_gozler=new ArrayList<Texture>();
        erkek_kaslar=new ArrayList<Texture>();
        erkek_saclar=new ArrayList<Texture>();
        erkek_ayakkabilar=new ArrayList<Texture>() ;
        erkek_gomlekler=new ArrayList<Texture>() ;
        erkek_burunlar=new ArrayList<Texture>();




        erkek_burun=new Texture(Gdx.files.internal("erkek/erkek_burun.png"));
        erkek_gomlek=new Texture(Gdx.files.internal("erkek/erkek_gomlek.png"));
        erkek_ayakkabi=new Texture(Gdx.files.internal("erkek/erkek_ayakkabi.png"));

        erkek_dudak1=new Texture(Gdx.files.internal("erkek/erkek_dudak1.png"));
        erkek_dudak2=new Texture(Gdx.files.internal("erkek/erkek_dudak2.png"));
        erkek_dudak3=new Texture(Gdx.files.internal("erkek/erkek_dudak3.png"));

        erkek_goz=new Texture(Gdx.files.internal("erkek/erkek_goz.png"));
        erkek_goz1=new Texture(Gdx.files.internal("erkek/erkek_goz1.png"));
        erkek_goz2=new Texture(Gdx.files.internal("erkek/erkek_goz2.png"));

        erkek_pantolon=new Texture(Gdx.files.internal("erkek/erkek_pantolon.png"));
        erkek_pantolon1=new Texture(Gdx.files.internal("erkek/erkek_pantolon1.png"));
        erkek_pantolon2=new Texture(Gdx.files.internal("erkek/erkek_pantolon2.png"));

        erkek_sac=new Texture(Gdx.files.internal("erkek/erkek_sac.png"));
        erkek_sac1=new Texture(Gdx.files.internal("erkek/erkek_sac1.png"));
        erkek_sac2=new Texture(Gdx.files.internal("erkek/erkek_sac2.png"));

        erkek_ten=new Texture(Gdx.files.internal("erkek/erkek_ten.png"));
        erkek_ten1=new Texture(Gdx.files.internal("erkek/erkek_ten1.png"));
        erkek_ten2=new Texture(Gdx.files.internal("erkek/erkek_ten2.png"));
        erkek_ten3=new Texture(Gdx.files.internal("erkek/erkek_ten3.png"));

        erkek_kas = new Texture(Gdx.files.internal("erkek/erkek_kas.png"));
        erkek_kas1 = new Texture(Gdx.files.internal("erkek/erkek_kas1.png"));
        erkek_kas2 = new Texture(Gdx.files.internal("erkek/erkek_kas2.png"));

        erkek_ayakkabilar.add(erkek_ayakkabi);
        erkek_gomlekler.add(erkek_gomlek);
        erkek_burunlar.add(erkek_burun);

        erkek_dudaklar.add(erkek_dudak1);
        erkek_dudaklar.add(erkek_dudak2);
        erkek_dudaklar.add(erkek_dudak3);

        erkek_tenler.add(erkek_ten);
        erkek_tenler.add(erkek_ten1);
        erkek_tenler.add(erkek_ten2);
        erkek_tenler.add(erkek_ten3);

        erkek_pantolonlar.add(erkek_pantolon);
        erkek_pantolonlar.add(erkek_pantolon1);
        erkek_pantolonlar.add(erkek_pantolon2);

        erkek_gozler.add(erkek_goz);
        erkek_gozler.add(erkek_goz1);
        erkek_gozler.add(erkek_goz2);

        erkek_saclar.add(erkek_sac);
        erkek_saclar.add(erkek_sac1);
        erkek_saclar.add(erkek_sac2);

        erkek_kaslar.add(erkek_kas);
        erkek_kaslar.add(erkek_kas2);
        erkek_kaslar.add(erkek_kas1);
        /*----------------------------------------------*/
         amca_dudaklar=new ArrayList<Texture>();
         amca_pantolonlar=new ArrayList<Texture>();
         amca_gozler=new ArrayList<Texture>();
         amca_kaslar=new ArrayList<Texture>();
         amca_tisortler=new ArrayList<Texture>();
         amca_tenler=new ArrayList<Texture>();
         amca_saclar=new ArrayList<Texture>();
         amca_burunlar=new ArrayList<Texture>();
         amca_ayakkabilar=new ArrayList<Texture>();
         amca_gozlukler=new ArrayList<Texture>();




         amca_burun = new Texture(Gdx.files.internal("amca/amca_burun.png"));
         amca_ayakkabi = new Texture(Gdx.files.internal("amca/amca_ayakkabi.png"));
         amca_biyik= new Texture(Gdx.files.internal("amca/amca_biyik.png"));

         amca_dudak = new Texture(Gdx.files.internal("amca/amca_dudak.png"));
         amca_dudak1 = new Texture(Gdx.files.internal("amca/amca_dudak1.png"));

         amca_goz = new Texture(Gdx.files.internal("amca/amca_goz.png"));
         amca_goz1 = new Texture(Gdx.files.internal("amca/amca_goz1.png"));
         amca_gozluk = new Texture(Gdx.files.internal("amca/amca_gozluk.png"));

         amca_kas = new Texture(Gdx.files.internal("amca/amca_kas.png"));
         amca_kas1 = new Texture(Gdx.files.internal("amca/amca_kas1.png"));
         amca_kas2 = new Texture(Gdx.files.internal("amca/amca_kas2.png"));

         amca_pantolon = new Texture(Gdx.files.internal("amca/amca_pantolon.png"));
         amca_pantolon1 = new Texture(Gdx.files.internal("amca/amca_pantolon1.png"));
         amca_pantolon2 = new Texture(Gdx.files.internal("amca/amca_pantolon2.png"));

         amca_sac = new Texture(Gdx.files.internal("amca/amca_sac.png"));

         amca_ten = new Texture(Gdx.files.internal("amca/amca_ten.png"));
         amca_ten1 = new Texture(Gdx.files.internal("amca/amca_ten1.png"));
         amca_ten2 = new Texture(Gdx.files.internal("amca/amca_ten2.png"));

         amca_tisort = new Texture(Gdx.files.internal("amca/amca_tisort.png"));
         amca_tisort1 = new Texture(Gdx.files.internal("amca/amca_tisort1.png"));
         amca_tisort2 = new Texture(Gdx.files.internal("amca/amca_tisort2.png"));
         amca_tisort3 = new Texture(Gdx.files.internal("amca/amca_tisort3.png"));


            amca_saclar.add(amca_sac);
            amca_burunlar.add(amca_burun);
            amca_ayakkabilar.add(amca_ayakkabi);
            amca_gozlukler.add(amca_gozluk);

            amca_tisortler.add(amca_tisort);
            amca_tisortler.add(amca_tisort1);
            amca_tisortler.add(amca_tisort2);
            amca_tisortler.add(amca_tisort3);

            amca_pantolonlar.add(amca_pantolon);
            amca_pantolonlar.add(amca_pantolon1);
            amca_pantolonlar.add(amca_pantolon2);

            amca_tenler.add(amca_ten);
            amca_tenler.add(amca_ten2);
            amca_tenler.add(amca_ten1);

            amca_kaslar.add(amca_kas);
            amca_kaslar.add(amca_kas1);
            amca_kaslar.add(amca_kas2);

            amca_dudaklar.add(amca_dudak);
            amca_dudaklar.add(amca_dudak1);

            amca_gozler.add(amca_goz);
            amca_gozler.add(amca_goz1);

        /*------------------------------------------------*/
        teyze_tisortler = new ArrayList<Texture>();
        teyze_tenler= new ArrayList<Texture>();
        teyze_kolyeler= new ArrayList<Texture>();
        teyze_saclar= new ArrayList<Texture>();
        teyze_dudaklar= new ArrayList<Texture>();
        teyze_kaslar= new ArrayList<Texture>();
        teyze_gozler= new ArrayList<Texture>();
        teyze_ayakkabilar= new ArrayList<Texture>();
        teyze_gozlukler= new ArrayList<Texture>();
        teyze_etekler= new ArrayList<Texture>();
        teyze_burunlar= new ArrayList<Texture>();




        teyze_kas=new Texture(Gdx.files.internal("teyze/teyze_kas1.png"));

          teyze_ayakkabi = new Texture(Gdx.files.internal("teyze/teyze_ayakkabi.png"));

          teyze_burun = new Texture(Gdx.files.internal("teyze/teyze_burun.png"));

          teyze_dudak = new Texture(Gdx.files.internal("teyze/teyze_dudak.png"));
          teyze_dudak1 = new Texture(Gdx.files.internal("teyze/teyze_dudak1.png"));
          teyze_dudak2 = new Texture(Gdx.files.internal("teyze/teyze_dudak2.png"));

          teyze_etek = new Texture(Gdx.files.internal("teyze/teyze_etek.png"));

          teyze_goz = new Texture(Gdx.files.internal("teyze/teyze_goz.png"));

          teyze_gozluk = new Texture(Gdx.files.internal("teyze/teyze_gozluk.png"));

          teyze_kolye = new Texture(Gdx.files.internal("teyze/teyze_kolye.png"));
          teyze_kolye1 = new Texture(Gdx.files.internal("teyze/teyze_kolye1.png"));
          teyze_kolye2 = new Texture(Gdx.files.internal("teyze/teyze_kolye2.png"));

          teyze_sac = new Texture(Gdx.files.internal("teyze/teyze_sac.png"));
          teyze_sac1 = new Texture(Gdx.files.internal("teyze/teyze_sac1.png"));
          teyze_sac2 = new Texture(Gdx.files.internal("teyze/teyze_sac2.png"));

          teyze_ten = new Texture(Gdx.files.internal("teyze/teyze_ten.png"));
          teyze_ten1 = new Texture(Gdx.files.internal("teyze/teyze_ten1.png"));
          teyze_ten2 = new Texture(Gdx.files.internal("teyze/teyze_ten2.png"));

          teyze_tisort = new Texture(Gdx.files.internal("teyze/teyze_tisort.png"));
          teyze_tisort1 = new Texture(Gdx.files.internal("teyze/teyze_yelek.png"));
          teyze_tisort2 = new Texture(Gdx.files.internal("teyze/teyze_yelek1.png"));
          teyze_tisort3 = new Texture(Gdx.files.internal("teyze/teyze_yelek2.png"));

        teyze_kaslar.add(teyze_kas);
        teyze_gozler.add(teyze_goz);
        teyze_ayakkabilar.add(teyze_ayakkabi);
        teyze_gozlukler.add(teyze_gozluk);
        teyze_etekler.add(teyze_etek);
        teyze_burunlar.add(teyze_burun);

        teyze_tisortler.add(teyze_tisort1);
        teyze_tisortler.add(teyze_tisort2);
        teyze_tisortler.add(teyze_tisort3);

        teyze_tenler.add(teyze_ten);
        teyze_tenler.add(teyze_ten1);
        teyze_tenler.add(teyze_ten2);

        teyze_kolyeler.add(teyze_kolye);
        teyze_kolyeler.add(teyze_kolye1);
        teyze_kolyeler.add(teyze_kolye2);

        teyze_saclar.add(teyze_sac);
        teyze_saclar.add(teyze_sac1);
        teyze_saclar.add(teyze_sac2);

        teyze_dudaklar.add(teyze_dudak);
        teyze_dudaklar.add(teyze_dudak1);
        teyze_dudaklar.add(teyze_dudak2);


    }

    public void loadBG(){

        gameScreenBG = new Texture(Gdx.files.internal("screens/gameScreenBG.jpg"));
        createGameScreenBG = new Texture(Gdx.files.internal("screens/createGameScreenBG.jpg"));
        joinGameScreenBG = new Texture(Gdx.files.internal("screens/joinGameScreenBG.jpg"));
        lobbyScreenBG = new Texture(Gdx.files.internal("screens/lobbyScreenBG.jpg"));
        loginScreenBG = new Texture(Gdx.files.internal("screens/loginScreenBG.jpg"));
        registerScreenBG = new Texture(Gdx.files.internal("screens/registerScreenBG.jpg"));
        customScreenBG=new Texture(Gdx.files.internal("screens/customScreenBG.png"));



    }

}
