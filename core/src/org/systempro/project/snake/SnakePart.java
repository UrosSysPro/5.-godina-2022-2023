package org.systempro.project.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SnakePart {
    public int x,y;
    public SnakePart(int x,int y) {
        this.x=x;
        this.y=y;
    }

    public void draw(ShapeRenderer renderer, float cellSize){
        renderer.rect(x*cellSize,y*cellSize,cellSize,cellSize);
    }
}
