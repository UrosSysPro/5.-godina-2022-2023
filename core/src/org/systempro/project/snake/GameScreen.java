package org.systempro.project.snake;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class GameScreen implements Screen {

    ShapeRenderer renderer;
    Snake snake;
    Food food;
    float cellSize;
    int width,height;

    Random random;

    @Override
    public void show() {
        width=80;
        height=60;
        cellSize=10;
        snake=new Snake(10,width,height);
        random=new Random();
        food=new Food(random.nextInt(width),random.nextInt(height), Color.RED);
        renderer=new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);

        snake.input();
        snake.update(width,height);
        food.update(snake,random,width,height);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        snake.draw(renderer,cellSize);
        food.draw(renderer,cellSize);

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
