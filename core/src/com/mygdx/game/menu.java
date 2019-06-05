package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GameConstant;
import com.mygdx.game.Main;

public class menu implements Screen {

    final Main game;
    private Stage stage;
    private Skin mySkin;
    private Viewport viewport;

    public menu(final Main game){
        this.game=game;

        mySkin = new Skin(Gdx.files.internal(GameConstant.skin));
        stage = new Stage(game.screenPort);
        Gdx.input.setInputProcessor(stage);



        Label gameTitle = new Label("Game Menu",mySkin,"big");
        //gameTitle.setSize(GameConstant.centerX*6,GameConstant.row_height*4);
        gameTitle.setSize(500,500);
        //gameTitle.setPosition(0,GameConstant.centerY);
        gameTitle.setPosition(GameConstant.centerX-gameTitle.getWidth()/2,GameConstant.centerY+GameConstant.row_height);
        gameTitle.setAlignment(Align.center);


        Button startBtn = new TextButton("Start Game",mySkin,"default"); // btn for start game
        startBtn.setSize(GameConstant.col_width*4,GameConstant.row_height);
        startBtn.setPosition(GameConstant.centerX-startBtn.getWidth()/2,GameConstant.centerY);
        startBtn.addListener(new InputListener(){


            //when touch the button
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //this.setScreen(new GameScreen(this));
                game.gotoGameScreen();
                return true;
            }

        });

        Button setting_easy = new TextButton("Easy",mySkin,"default"); // btn for setting_easy
        //setting_easy.setSize(GameConstant.col_width,GameConstant.row_height);
        setting_easy.setPosition(50,690);
        setting_easy.addListener(new InputListener(){


            //when touch the button
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoGameScreen();
                return true;
            }

        });



        Button setting_normal = new TextButton("Normal",mySkin,"default"); // btn for setting_normal
        //setting_normal.setSize(GameConstant.col_width,GameConstant.row_height);
        setting_normal.setPosition(400,690);
        setting_normal.addListener(new InputListener(){


            //when touch the button
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

        });

        Button setting_hard = new TextButton("Hard",mySkin,"default"); // btn for setting_hard
        //setting_hard.setSize(GameConstant.col_width*4,GameConstant.row_height);
        setting_hard.setPosition(750,690);
        setting_hard.addListener(new InputListener(){


            //when touch the button
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

        });

        //add title and btn
        stage.addActor(gameTitle);
        stage.addActor(startBtn);
        stage.addActor(setting_easy);
        stage.addActor(setting_normal);
        stage.addActor(setting_hard);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        //viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose(){
        //game.batch.dispose();
        mySkin.dispose();
        stage.dispose();
    }
}
