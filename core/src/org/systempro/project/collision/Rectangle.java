package org.systempro.project.collision;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Rectangle {
    public float x,y,width,height;
    public Color color;
    public Rectangle(float x,float y,float width,float height,Color color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
    }
    public boolean collidesWith(Rectangle r){
        if(x>r.x+r.width||x+width<r.x||y>r.y+r.height||y+width<r.y){
            return false;
        }else {
            return true;
        }
    }
    public void draw(ShapeRenderer renderer){
        renderer.setColor(color);
        renderer.rect(x,y,width,height);
    }
}
