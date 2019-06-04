package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private Main game;
    private int width = 600;//600 GameScreen
    private int height = 1000;//1000
    private OrthographicCamera camera = new OrthographicCamera(width, height);
    private Viewport viewport;
    private GameState gameState = new GameState();

    public GameScreen(Main game) {
        this.game = game;
        camera.setToOrtho(false, width, height);
        //to fill the screen
        viewport = new FitViewport(width, height, camera);
        viewport.apply();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        viewport.apply();
        // call gameState's update method every tick and give it delta
        gameState.update(delta, viewport);
        //RGB values
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameState.draw(width, height, camera);
        // System.out.println(delta);

    }

    @Override
    public void resize(int width, int height) {
        //This updates the viewport when the game window is resized or on a computer
        viewport.update(width, height);
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
