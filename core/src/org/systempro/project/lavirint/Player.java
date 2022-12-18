package org.systempro.project.lavirint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.systempro.project.collision.Rectangle;

public class Player {
    float x,y,width,height,vx,vy;
    public Player(float x,float y,float width,float height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        vx=0;
        vy=0;
    }
    public void input(){
        vx=0;
        vy=0;
        float speed=2;
        if(Gdx.input.isKeyPressed(Input.Keys.W))vy=-speed;
        if(Gdx.input.isKeyPressed(Input.Keys.S))vy=speed;
        if(Gdx.input.isKeyPressed(Input.Keys.A))vx=-speed;
        if(Gdx.input.isKeyPressed(Input.Keys.D))vx=speed;
    }
    public void update(int[][] maze,int cellSize){
        int x,y;
        this.x+=vx;
        x=(int)this.x/cellSize;
        y=(int)this.y/cellSize;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i+x<0||j+y<0||x+i>=maze.length||y+j>=maze[0].length){
                    continue;
                }
                if(maze[x+i][y+j]==-2){
                    int rx=(x+i)*cellSize;
                    int ry=(y+j)*cellSize;
                    if(collidesWith(rx,ry,cellSize,cellSize)){
                        this.x-=vx;
                    }
                }
            }
        }
        this.y+=vy;
        x=(int)this.x/cellSize;
        y=(int)this.y/cellSize;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i+x<0||j+y<0||x+i>=maze.length||y+j>=maze[0].length){
                    continue;
                }
                if(maze[x+i][y+j]==-2){
                    int rx=(x+i)*cellSize;
                    int ry=(y+j)*cellSize;
                    if(collidesWith(rx,ry,cellSize,cellSize)){
                        this.y-=vy;
                    }
                }
            }
        }
    }
    public void draw(ShapeRenderer renderer){
        renderer.setColor(Color.LIME);
        float y=Gdx.graphics.getHeight()-this.y-height;
        renderer.rect(x,y,width,height);
    }
    public boolean collidesWith(float rx,float ry,float rwidth,float rheight){
        if(x>rx+rwidth||x+width<rx||y>ry+rheight||y+width<ry){
            return false;
        }else {
            return true;
        }
    }
}
