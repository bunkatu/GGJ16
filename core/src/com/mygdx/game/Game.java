package com.mygdx.game;

import java.util.ArrayList;

public class Game {

    public int id;
    public String name;
    public ArrayList<Player> players;

    public Game(){

        players = new ArrayList<Player>();

    }

    public void addPlayer(Player p){
        players.add(p);
    }

}
