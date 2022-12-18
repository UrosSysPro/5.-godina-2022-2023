package org.systempro.project.lavirint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestScreen implements Screen {
    Game game;
    @Override
    public void show() {
        int cellSize=25;
        game=new Game(cellSize);
//        game.print();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        game.input();
        game.update(delta);
        game.draw();
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
