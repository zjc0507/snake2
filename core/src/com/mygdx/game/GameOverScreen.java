package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public class GameOverScreen implements Screen {

    private static final int BANNER_WIDTH=350;
    private static final int BANNER_HEIGHT=100;


    Main game;
    int score,highscore;

    Texture gameoverBanner;
    BitmapFont scoreFont;

    public GameOverScreen(Main game,int score){
        this.game=game;
        this.score=score;


        //get highscore from save file
        Preferences prefs = Gdx.app.getPreferences("snake");
        this.highscore=prefs.getInteger("highscore",0);

        //check if score beats highscore
        if(score> highscore){
            prefs.putInteger("highscore",score);
            prefs.flush();
        }

        //load textures and fonts
        gameoverBanner = new Texture("game_over.png");
        scoreFont=new BitmapFont(Gdx.files.internal("score.fnt"));
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(gameoverBanner,Gdx.graphics.getWidth()/2-BANNER_WIDTH/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15,BANNER_WIDTH,BANNER_HEIGHT);

        GlyphLayout scoreLayout = new GlyphLayout(scoreFont,"Score: \n" + score, Color.WHITE,0, Align.left,false);
        GlyphLayout highscorreLayout = new GlyphLayout(scoreFont,"Highscore: \n" + highscore, Color.WHITE,0, Align.left,false);
        scoreFont.draw(game.batch,scoreLayout,Gdx.graphics.getWidth()/2-scoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15*2);
        scoreFont.draw(game.batch,highscorreLayout,Gdx.graphics.getWidth()/2-highscorreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-scoreLayout.height-15*2);

        GlyphLayout tryAgainLayout = new GlyphLayout(scoreFont,"Try Again");
        GlyphLayout mainMenuLayout = new GlyphLayout(scoreFont,"Main Menu");

        float tryAgainX = Gdx.graphics.getWidth()/2-tryAgainLayout.width/2;
        float tryAgainY = Gdx.graphics.getHeight()/2-tryAgainLayout.height/2;
        float mainMenuX = Gdx.graphics.getWidth()/2-mainMenuLayout.width/2;
        float mainMenuY = Gdx.graphics.getHeight()/2-mainMenuLayout.height/2 - tryAgainLayout.height-15;

        float touchX = Gdx.input.getX(),touchY=Gdx.graphics.getHeight()-Gdx.input.getY();

        //if try again and menu is being pressed
        if(Gdx.input.isTouched()){
            //try again
            if(touchX > tryAgainX && touchX < tryAgainX + tryAgainLayout.width && touchY > tryAgainY - tryAgainLayout.height && touchY<tryAgainY ){
                this.dispose();
                game.batch.end();
                game.setScreen(new GameScreen(game));
                return;
            }

            //try menu
            if(touchX > mainMenuX && touchX < mainMenuX + mainMenuLayout.width && touchY > mainMenuY - mainMenuLayout.height && touchY<mainMenuY ){
                this.dispose();
                game.batch.end();
                game.setScreen(new menu(game));
                return;
            }
        }

        //draw buttons
        scoreFont.draw(game.batch,tryAgainLayout,tryAgainX,tryAgainY);
        scoreFont.draw(game.batch,mainMenuLayout,mainMenuX,mainMenuY);
        game.batch.end();
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
