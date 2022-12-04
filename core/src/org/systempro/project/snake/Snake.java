package org.systempro.project.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Snake {
    int n;
    SnakePart[] parts;
    int smerX,smerY;

    public Snake(int n,int width,int height){
        smerX=0;
        smerY=0;
        this.n=n;
        parts=new SnakePart[1000];
        for(int i=0;i<n;i++){
            parts[i]=new SnakePart(width/2,height/2);
        }
    }

    public void input(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            smerY=1;
            smerX=0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            smerY=-1;
            smerX=0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            smerY=0;
            smerX=-1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            smerY=0;
            smerX=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            add();
        }
    }
    public void update(int width,int height){
        for(int i=n-1;i>=1;i--){
            parts[i].x=parts[i-1].x;
            parts[i].y=parts[i-1].y;
        }
        parts[0].x+=smerX;
        parts[0].y+=smerY;

        if(parts[0].x>width)parts[0].x=0;
        if(parts[0].x<0)parts[0].x=width-1;
        if(parts[0].y>height)parts[0].y=0;
        if(parts[0].y<0)parts[0].y=height-1;
    }
    public void draw(ShapeRenderer renderer,float cellSize){
        renderer.setColor(Color.GREEN);
        for(int i=0;i<n;i++){
            parts[i].draw(renderer,cellSize);
        }
    }
    public void add(){
        parts[n]=new SnakePart(parts[n-1].x,parts[n-1].y);
        n++;
    }
}
