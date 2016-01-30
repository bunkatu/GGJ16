package network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mygdx.game.GGJ16;
import com.mygdx.game.Lobby;

import java.io.IOException;
import java.util.ArrayList;

import network.lobby.CreateLobby;
import network.lobby.DeleteLobby;
import network.lobby.JoinLobby;
import network.lobby.LeaveLobby;
import network.lobby.UserCreatedLobby;
import network.lobby.UserDeletedLobby;
import network.lobby.UserJoinedLobby;
import network.lobby.UserLeftLobby;
import network.lobby.UserReadyLobby;
import network.login.Login;
import network.login.LoginFailure;
import network.login.LoginSuccess;
import network.register.Register;
import network.register.RegisterFailure;
import network.register.RegisterSuccess;

public class Network extends Listener {

    public Client client;
    public GGJ16 game;
    String ip = "146.185.171.56";
    //String ip = "localhost";
    int port = 27960;

    public void connect(){
        client = new Client();

        // todo: register classes here
        client.getKryo().register(ArrayList.class);

        client.getKryo().register(Register.class);
        client.getKryo().register(RegisterSuccess.class);
        client.getKryo().register(RegisterFailure.class);

        client.getKryo().register(Login.class);
        client.getKryo().register(LoginSuccess.class);
        client.getKryo().register(LoginFailure.class);

        client.getKryo().register(CreateLobby.class);
        client.getKryo().register(UserCreatedLobby.class);
        client.getKryo().register(JoinLobby.class);
        client.getKryo().register(UserJoinedLobby.class);
        client.getKryo().register(LeaveLobby.class);
        client.getKryo().register(UserLeftLobby.class);
        client.getKryo().register(DeleteLobby.class);
        client.getKryo().register(UserDeletedLobby.class);

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
            game.player.online = true;
            System.out.println("User successfully logged in.");
        }

        if(o instanceof LoginFailure){
            game.player.online = false;
            System.out.println("User could not logged in.");
        }

        if(o instanceof RegisterSuccess){
            game.player.registered = true;
            System.out.println("User successfully registered.");
        }

        if(o instanceof RegisterFailure){
            game.player.registered = false;
            System.out.println("User could not registered.");
        }

        if(o instanceof UserCreatedLobby){
            UserCreatedLobby packet = (UserCreatedLobby) o;
            Lobby l = new Lobby();
            l.id = packet.id;
            l.name = packet.name;
            l.players = packet.players;
            l.size = packet.size;
            game.lobbies.add(l);
            System.out.println("A user created a new lobby.");
        }

        if(o instanceof UserJoinedLobby){
            UserJoinedLobby packet = (UserJoinedLobby) o;
            Lobby l = get_lobby(packet.lobby_id);
            l.players.add(packet.username);
            System.out.println("A user joined a lobby.");
        }

        if(o instanceof UserLeftLobby){
            UserLeftLobby packet = (UserLeftLobby) o;
            Lobby l = get_lobby(packet.lobby_id);

            for(int i=0; i<l.players.size(); i++){
                if(l.players.get(i).equals(packet.username)){
                    l.players.remove(i);
                }
            }
            System.out.println("A user left a lobby.");
        }

        if(o instanceof UserDeletedLobby){
            UserDeletedLobby packet = (UserDeletedLobby) o;

            for(int i=0; i<game.lobbies.size(); i++){
                if(game.lobbies.get(i).id == packet.lobby_id){
                    game.lobbies.remove(i);
                }
            }

            System.out.println("A user deleted a lobby.");
        }

        if(o instanceof UserReadyLobby){
            UserReadyLobby packet = (UserReadyLobby) o;

            for(int i=0; i<game.lobbies.size(); i++){
                if(game.lobbies.get(i).id == packet.lobby_id){
                    for(int j=0; j<game.lobbies.get(i).players.size(); j++){
                        if(game.lobbies.get(i).players.get(j).equals(packet.username)){
                            game.lobbies.get(i).ready.add(packet.username);
                        }
                    }
                }
            }

            System.out.println("A user clicked ready in a lobby.");
        }

    }

    public Lobby get_lobby(int id){

        for(int i=0; i<game.lobbies.size(); i++){
            if(game.lobbies.get(i).id == id){
                return game.lobbies.get(i);
            }
        }

    }

}
