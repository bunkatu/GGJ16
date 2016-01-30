package network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mygdx.game.*;
import com.mygdx.game.Player;

import java.io.IOException;
import java.util.ArrayList;

import network.game.CreateGame;
import network.game.LeaveGame;
import network.game.SendMessage;
import network.game.UserCreatedGame;
import network.game.UserLeftGame;
import network.game.UserSentMessage;
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
import network.player.ChangeAppearance;
import network.player.UserChangedAppearance;
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

        client.getKryo().register(CreateGame.class);
        client.getKryo().register(UserCreatedGame.class);
        client.getKryo().register(LeaveGame.class);
        client.getKryo().register(UserLeftGame.class);

        client.getKryo().register(SendMessage.class);
        client.getKryo().register(UserSentMessage.class);

        client.getKryo().register(ChangeAppearance.class);
        client.getKryo().register(UserChangedAppearance.class);

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
            LoginSuccess l = (LoginSuccess) o;
            game.player.username = l.username;
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

        if(o instanceof UserCreatedGame){
            UserCreatedGame packet = (UserCreatedGame) o;

            boolean gameCreated = false;
            for(int i=0; i<packet.players.size(); i++){
                if(packet.players.get(i).equals(game.player.username)){
                    gameCreated = true;
                }
            }

            if(gameCreated){
                game.gameState.active = true;
                for(int i=0; i<packet.players.size(); i++){
                    game.gameState.players.add(packet.players.get(i));
                }
            }

            System.out.println("A user created a game.");
        }

        if(o instanceof UserLeftGame){
            UserLeftGame packet = (UserLeftGame) o;

            if(game.gameState.id == packet.game_id){
                for(int i=0; i<game.gameState.players.size(); i++){
                    if(game.gameState.players.get(i).equals(packet.username)){
                        game.gameState.players.remove(i);

                        if(packet.username.equals(game.player.username)){
                            game.gameState.active = false;
                        }

                    }
                }
            }

            System.out.println("A user left a game.");
        }

        if(o instanceof UserSentMessage){
            UserSentMessage packet = (UserSentMessage) o;

            if(game.gameState.id == packet.game_id){
                game.gameState.messages.add(packet.message);
            }

            System.out.println("A user sent a message.");
        }

        if(o instanceof UserChangedAppearance){
            UserChangedAppearance packet = (UserChangedAppearance) o;

            if(game.player.username.equals(packet.username)){
                game.player.type = packet.type;
                game.player.hair = packet.hair;
                game.player.eyes = packet.eyes;
                game.player.lips = packet.lips;
                game.player.skin = packet.skin;
                game.player.dress = packet.dress;
                game.player.eyebrows = packet.eyebrows;
                game.player.shirt = packet.shirt;
                game.player.glasses = packet.glasses;
                game.player.moustache = packet.moustache;
                game.player.shoes = packet.shoes;
            }

            for(int i=0; i<game.gameState.players.size(); i++){
                if(game.gameState.players.get(i).equals(packet.username)){
                    com.mygdx.game.Player p = new Player();
                    p.username = packet.username;
                    p.type = packet.type;
                    p.hair = packet.hair;
                    p.eyes = packet.eyes;
                    p.lips = packet.lips;
                    p.skin = packet.skin;
                    p.dress = packet.dress;
                    p.eyebrows = packet.eyebrows;
                    p.shirt = packet.shirt;
                    p.glasses = packet.glasses;
                    p.moustache = packet.moustache;
                    p.shoes = packet.shoes;
                    game.gameState.playerTypes.add(p);
                }
            }

            System.out.println("Player appearance change applied.");
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
