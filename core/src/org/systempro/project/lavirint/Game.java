package org.systempro.project.lavirint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Game {

    public int[][] mapa;
    public int width,height;
    float cellSize;
    public Random random;
    ShapeRenderer renderer;
    int max=0;

    public Game(int width,int height){
        random=new Random();
        renderer=new ShapeRenderer();
        this.cellSize= (float) Gdx.graphics.getHeight()/height;
        this.width=width;
        this.height=height;
        mapa=new int[width][height];
        randomize();
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
    public void print(){
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }
    public void draw(){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLACK);
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                if(mapa[i][j]==-2)
                    renderer.setColor(Color.BLACK);
                else if(mapa[i][j]==-1)
                    renderer.setColor(Color.DARK_GRAY);
                else if(mapa[i][j]==0)
                    renderer.setColor(Color.WHITE);
                else{
                    float alfa=(float)mapa[i][j]/(width);
                    renderer.setColor(
                        new Color(
                            Color.BLUE.r*alfa+(1-alfa)*Color.CORAL.r,
                            Color.BLUE.g*alfa+(1-alfa)*Color.CORAL.g,
                            Color.BLUE.b*alfa+(1-alfa)*Color.CORAL.b,
                            1f
                        )
                    );
                }
                float x=i*cellSize;
                float y=(height-j-1)*cellSize;
                renderer.rect(x,y,cellSize,cellSize);
            }
        }
        renderer.end();
    }
    public static void main(String[] args) {
        Game game=new Game(50,50);
        game.randomize();
        game.print();
    }
}
