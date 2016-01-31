package com.mygdx.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GameState {

    public int id;
    public boolean active;
    public ArrayList<String> players;
    public ArrayList<Player> playerTypes;
    public ArrayList<String> roles;
    public Queue<String> messages;
    public String demon;
    public int turn;
    public Map<String, Integer> votes;

    public GameState(){
        active = false;
        players = new ArrayList<String>();
        roles = new ArrayList<String>();
        messages = new LinkedList<String>();
        turn = 0;
    }

}
