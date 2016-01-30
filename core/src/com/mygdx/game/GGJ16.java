package com.mygdx.game;

import network.Network;
import screens.LoadingScreen;
import assets.Textures;
import com.badlogic.gdx.Game;

import java.util.ArrayList;

public class GGJ16 extends Game {

	public Textures textures;
	public Network network;
	public Player player;
	public ArrayList<Lobby> lobbies;

	@Override
	public void create() {

		textures = new Textures();

		network = new Network();
		network.connect();
		network.game = this;

		player = new Player();
		lobbies = new ArrayList<Lobby>();

		this.setScreen(new LoadingScreen(this));
	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {
		super.render();
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
}
