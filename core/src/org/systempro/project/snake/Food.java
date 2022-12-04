package org.systempro.project.snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Food {
    public int x,y;
    public Color color;
    public Food(int x,int y,Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }

    public void update(Snake snake, Random random,int width,int height){
        if(x== snake.parts[0].x&&y==snake.parts[0].y){
            snake.add();
            x=random.nextInt(width);
            y=random.nextInt(height);
        }
    }

    public void draw(ShapeRenderer renderer,float cellSize){
        renderer.setColor(color);
        renderer.rect(x*cellSize,y*cellSize,cellSize,cellSize);
    }
}
