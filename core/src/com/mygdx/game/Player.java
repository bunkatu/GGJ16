package com.mygdx.game;

public class Player {

    public String username;
    public String mail;
    public String password;
    public int currentGame;
    public boolean logged_in;
    public boolean is_registered;

    public Player(){

        username = "";
        mail = "";
        password = "";
        currentGame = 0;
        logged_in = false;
        is_registered = false;

    }

}
