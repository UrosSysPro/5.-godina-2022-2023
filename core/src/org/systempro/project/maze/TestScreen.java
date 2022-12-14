package org.systempro.project.maze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import org.systempro.project.BasicScreen;

public class TestScreen extends BasicScreen {

    public Maze bfs;
    ShapeRenderer renderer;
    @Override
    public void show() {
        bfs=new Maze("assets/lavirint.txt");
        bfs.print();
        renderer=new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        int x=Gdx.input.getX()/bfs.cellSize;
        int y=Gdx.input.getY()/bfs.cellSize;
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            if(x>=0&&x<bfs.width&&y>=0&&y< bfs.height)bfs.toggleBlock(x,y);
        }
        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
            if(x>=0&&x<bfs.width&&y>=0&&y< bfs.height)bfs.solveBfs(x,y);
        }
        bfs.draw(renderer);
    }

    @Override
    public void dispose() {

    }
}
