package org.systempro.project.collision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestScreen implements Screen {
    ShapeRenderer renderer;
    Rectangle[] rectangles;
    Rectangle mouse;
    @Override
    public void show() {
        rectangles=new Rectangle[3];
        renderer=new ShapeRenderer();
        rectangles[0]=new Rectangle(100,100,100,50, Color.GRAY);
        rectangles[1]=new Rectangle(400,100,50,200, Color.GRAY);
        rectangles[2]=new Rectangle(600,300,100,100, Color.GRAY);

        //mouse
        float x=Gdx.input.getX();
        float y=Gdx.graphics.getHeight()-Gdx.input.getY();
        float width=50;
        float height=50;
        mouse=new Rectangle(x-width/2,y-height/2,width,height,Color.GREEN);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        //input
        float x=Gdx.input.getX();
        float y=Gdx.input.getY();

        //update
        y=Gdx.graphics.getHeight()-y- mouse.height/2;
        x=x-mouse.width/2;
        mouse.x=x;
        mouse.y=y;

        boolean collides=false;
        for(int i=0;i<rectangles.length;i++){
            if(mouse.collidesWith(rectangles[i])){
                collides=true;
                break;
            }
        }
        if(collides)
            mouse.color=Color.RED;
        else
            mouse.color=Color.GREEN;

        //draw
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i=0;i<rectangles.length;i++){
            rectangles[i].draw(renderer);
        }
        mouse.draw(renderer);
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
