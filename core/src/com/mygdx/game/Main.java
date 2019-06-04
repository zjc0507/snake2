package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.menu;

public class Main extends Game {
	SpriteBatch batch;
	public Viewport screenPort;




	@Override
	public void create () {
		batch = new SpriteBatch();
		screenPort = new ScreenViewport();


		//go to main game screen
        //this.setScreen(new GameScreen(this));

		//start from menu screen
		this.setScreen(new menu((this)));

	}


	public  void gotoSettingsScreen(){
		SettingsScreen settingsScreen = new SettingsScreen(this);
		setScreen(settingsScreen);
	}

	public void gotoGameScreen(){
		GameScreen gameScreen=new GameScreen(this);
		//setScreen(gameScreen);
		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
