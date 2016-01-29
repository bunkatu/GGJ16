package network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mygdx.game.GGJ16;

import java.io.IOException;

public class Network extends Listener {

    public Client client;
    public GGJ16 game;
    String ip = "localhost";
    int port = 27960;

    public Network(GGJ16 game){
        this.game = game;
    }

    public void connect(){
        client = new Client();

        // todo: register classes here

        client.start();
        try {
            client.connect(5000, ip, port, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void received(Connection c, Object o){

    }


}
