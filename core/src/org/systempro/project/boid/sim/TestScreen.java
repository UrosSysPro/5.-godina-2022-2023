package org.systempro.project.boid.sim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class TestScreen implements Screen {
    ShapeRenderer renderer;
    Simulation sim;
    @Override
    public void show() {
        renderer=new ShapeRenderer();
        sim=new Simulation(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float x=Gdx.input.getX();
            float y=Gdx.input.getY();
            y=Gdx.graphics.getHeight()-y;
            sim.add(x,y);
        }
        sim.update();
        sim.draw(renderer);
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
