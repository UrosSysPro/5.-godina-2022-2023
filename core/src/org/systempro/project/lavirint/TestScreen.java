package org.systempro.project.lavirint;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestScreen implements Screen {
    Game game;
    @Override
    public void show() {
        game=new Game(80,60,10);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
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
