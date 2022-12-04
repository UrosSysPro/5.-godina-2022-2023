package org.systempro.project.pacman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Game {
    ShapeRenderer renderer;
    boolean[][] mapa;
    float cellSize;
    Player player;
    Random random;
    int width,height;
    public Game(int width,int height,int cellSize){
        renderer=new ShapeRenderer();
        this.width=width;
        this.height=height;
        random=new Random();
        this.cellSize=cellSize;
        mapa=new boolean[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                mapa[i][j]=random.nextFloat()>0.5f;
            }
        }
        player=new Player();
    }

    void update(){

    }
    void draw(){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLACK);
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(mapa[i][j])
                    renderer.rect(i*cellSize,j*cellSize,cellSize,cellSize);
            }
        }
        renderer.end();
    }

}
