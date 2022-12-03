package org.systempro.project.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import org.systempro.project.BasicScreen;

public class TestScreen extends BasicScreen {
    ShapeRenderer renderer;
    Vector2[] niz;

    @Override
    public void show() {
        renderer=new ShapeRenderer();
        niz=new Vector2[10];
        for(int i=0;i<niz.length;i++){
            niz[i]=new Vector2(0,0);
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        for(int i=niz.length-1;i>=1;i--){
            niz[i].x=niz[i-1].x;
            niz[i].y=niz[i-1].y;
        }
        float y=Gdx.graphics.getHeight()-Gdx.input.getY();
        float x=Gdx.input.getX();
        niz[0].set(x,y);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.CYAN);
        for(Vector2 v:niz){
            renderer.circle(v.x,v.y,20);
        }
        renderer.end();
    }
}
