package org.systempro.project.lavirint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Game {

    public int[][] mapa;
    public int width,height;
    public float cellSize;
    public Player player;
    public Random random;
    public ShapeRenderer renderer;
    public TextureRegion[][] regions;
    public SpriteBatch batch;
    public int max=0;

    public Game(int cellSize){
        regions=TextureRegion.split(
            new Texture("dungeonGrass.png"),
            16,
            16
        );
        random=new Random();
        renderer=new ShapeRenderer();
        batch=new SpriteBatch();
        this.cellSize= cellSize;

        this.width=Gdx.graphics.getWidth()/cellSize;
        this.height=Gdx.graphics.getHeight()/cellSize;
        mapa=new int[width][height];
        randomize();
        //player

        player=new Player(0,0,cellSize/2,cellSize/2);
    }
    public void randomize(){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                mapa[i][j]=-2;
            }
        }
        Stack<Point> stack=new Stack<>();
        mapa[0][0]=-1;
        stack.push(new Point(0,0));
        while (!stack.isEmpty()){
            Point[] unvisitedAround=new Point[4];
            int n=0;
            Point p=stack.peek();
            if(p.x-2>=0      && mapa[p.x-2][p.y  ]==-2){unvisitedAround[n]=new Point(p.x-2,p.y    );n++;}
            if(p.x+2< width  && mapa[p.x+2][p.y  ]==-2){unvisitedAround[n]=new Point(p.x+2,p.y    );n++;}
            if(p.y-2>=0      && mapa[p.x  ][p.y-2]==-2){unvisitedAround[n]=new Point(  p.x  ,p.y-2);n++;}
            if(p.y+2< height && mapa[p.x  ][p.y+2]==-2){unvisitedAround[n]=new Point(  p.x  ,p.y+2);n++;}

//            System.out.println(n);
            if(n==0){
                stack.pop();
                continue;
            }
            int index=random.nextInt(n);
//            int index=n-1;
            mapa[(p.x+unvisitedAround[index].x)/2][(p.y+unvisitedAround[index].y)/2]=-1;
            mapa[unvisitedAround[index].x][unvisitedAround[index].y]=-1;
            stack.push(unvisitedAround[index]);
        }
    }
    public void solveDfs(int x,int y){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                mapa[i][j]=mapa[i][j]==-2?-2:-1;
            }
        }
        Stack<Point> stack=new Stack<>();
        mapa[x][y]=0;
        stack.push(new Point(x,y));
        max=0;
        while (!stack.isEmpty()){
            if (stack.size()>max)max=stack.size();
            Point pos=stack.pop();
            int trenutno=mapa[pos.x][pos.y];
            if(pos.x-1>=0&&(mapa[pos.x-1][pos.y]==-1||mapa[pos.x-1][pos.y]>trenutno+1)){
                mapa[pos.x-1][pos.y]=trenutno+1;
                stack.push(new Point(pos.x-1,pos.y));
            }
            if(pos.x+1<width&&(mapa[pos.x+1][pos.y]==-1||mapa[pos.x+1][pos.y]>trenutno+1)){
                mapa[pos.x+1][pos.y]=trenutno+1;
                stack.push(new Point(pos.x+1,pos.y));
            }
            if(pos.y-1>=0&&(mapa[pos.x][pos.y-1]==-1||mapa[pos.x][pos.y-1]>trenutno+1)){
                mapa[pos.x][pos.y-1]=trenutno+1;
                stack.push(new Point(pos.x,pos.y-1));
            }
            if(pos.y+1<height&&(mapa[pos.x][pos.y+1]==-1||mapa[pos.x][pos.y+1]>trenutno+1)){
                mapa[pos.x][pos.y+1]=trenutno+1;
                stack.push(new Point(pos.x,pos.y+1));
            }
        }
        System.out.println(max);
    }

    public void input(){
        player.input();
    }
    public void update(float delta){
        Gdx.graphics.setTitle(""+(int)(delta*1000));
        player.update(mapa, (int) cellSize);
    }
    public void draw(){
        batch.begin();
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                TextureRegion region;
                if(mapa[i][j]!=-2){
                    region=regions[4][3];
                }else {
                    region=regions[8][1];
                }
                float x=i*cellSize;
                float y=(height-j-1)*cellSize;
                batch.draw(region,x,y,cellSize,cellSize);

            }
        }
        batch.end();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        player.draw(renderer);
        renderer.end();
    }
}
