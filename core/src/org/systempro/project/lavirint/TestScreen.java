package org.systempro.project.lavirint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestScreen implements Screen {
    Game game;
    @Override
    public void show() {
        int cellSize=10;
        game=new Game(Gdx.graphics.getWidth()/cellSize,Gdx.graphics.getHeight()/cellSize);
//        game.print();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            game.randomize();
        }
        int x= (int) (Gdx.input.getX()/game.cellSize);
        int y= (int) (Gdx.input.getY()/game.cellSize);
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            game.solveDfs(x,y);
        }
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            for(int i=-3;i<=3;i++){
                for(int j=-3;j<=3;j++){
                    if(x+i>=0&&x+i<game.width&&y+j>=0&&y+j< game.height)
                        game.mapa[x+i][y+j]=-2;
                }
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            for(int i=-3;i<=3;i++){
                for(int j=-3;j<=3;j++){
                    if(x+i>=0&&x+i<game.width&&y+j>=0&&y+j< game.height)
                        game.mapa[x+i][y+j]=-1;
                }
            }
        }
        Gdx.graphics.setTitle((int)(delta*1000)+"");
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
