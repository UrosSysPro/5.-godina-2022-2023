package org.systempro.project.boid.sim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import org.graalvm.nativebridge.In;

import java.util.ArrayList;
import java.util.Random;

public class TestScreen implements Screen {
    Random random;
    ArrayList<Boid> niz;
    ShapeRenderer renderer;

    @Override
    public void show() {
        random=new Random();
        niz=new ArrayList<>();
        renderer=new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        //input
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            float x=Gdx.input.getX();
            float y=Gdx.input.getY();
            y=Gdx.graphics.getHeight()-y;

            float vx=random.nextFloat()*6-3;
            float vy=random.nextFloat()*6-3;

            niz.add(new Boid(x,y,vx,vy));
        }
        //update
        float width=Gdx.graphics.getWidth();
        float height=Gdx.graphics.getHeight();
        for(Boid b:niz){
            b.update(width,height,niz);
        }
        //draw
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.LIME);
        for(Boid b:niz){
            renderer.circle(b.x,b.y,3);
        }
        renderer.end();
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
