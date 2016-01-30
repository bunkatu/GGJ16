package com.mygdx.game;

public class Player {

    public int id;
    public String username;
    public String mail;
    public String password;
    public boolean online;
    public boolean registered;

    // kiz = 0, oglan = 1, amca = 2, teyze = 3.
    public int type;
    public int hair;
    public int eyes;
    public int lips;
    public int skin;
    public int dress;
    public int eyebrows;
    public int shirt;
    public int glasses;
    public int moustache;
    public int shoes;

    public Player(){

        username = "";
        mail = "";
        password = "";
        online = false;
        registered = false;

    }

}
