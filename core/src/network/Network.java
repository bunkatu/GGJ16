package network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mygdx.game.GGJ16;

import java.io.IOException;

public class Network extends Listener {

    public Client client;
    public GGJ16 game;
    String ip = "146.185.171.56";
    //String ip = "localhost";
    int port = 27960;

    public void connect(){
        client = new Client();

        // todo: register classes here
        client.getKryo().register(Register.class);
        client.getKryo().register(RegisterSuccess.class);
        client.getKryo().register(RegisterFailure.class);

        client.getKryo().register(Login.class);
        client.getKryo().register(LoginSuccess.class);
        client.getKryo().register(LoginFailure.class);

        client.getKryo().register(RequestLobbyList.class);
        client.getKryo().register(CreateNewGame.class);
        client.getKryo().register(LobbyList.class);
        client.getKryo().register(Game.class);
        client.getKryo().register(Player.class);
        client.getKryo().register(java.util.ArrayList.class);

        client.addListener(this);

        client.start();
        try {
            client.connect(5000, ip, port, port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // Example packet sending
        // game.network.client.sendTCP(packet);

    }

    public void received(Connection c, Object o){

        if(o instanceof LoginSuccess){
            game.player.logged_in = true;
            game.player.answer_received = true;
            System.out.println("Successfully Logged In.");
        }

        if(o instanceof LoginFailure){
            game.player.logged_in = false;
            game.player.answer_received = true;
            System.out.println("Login Failed.");
        }

        if(o instanceof RegisterSuccess){
            game.player.is_registered = true;
            game.player.answer_received = true;
            System.out.println("Successfully Registered");
        }

        if(o instanceof RegisterFailure){
            game.player.is_registered = false;
            game.player.answer_received = true;
            System.out.println("Registration Failed.");
        }

        if(o instanceof LobbyList){
            LobbyList packet = (LobbyList) o;
            game.lobbyList = packet;
            System.out.println("Lobby List Received.");
        }

    }


}
