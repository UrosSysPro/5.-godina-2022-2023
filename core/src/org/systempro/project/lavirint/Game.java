package org.systempro.project.lavirint;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;
import java.util.Random;

public class Game {

    public boolean[][] mapa;
    public int width,height,cellSize;
    public Random random;
    ShapeRenderer renderer;

    public Game(int width,int height,int cellSize){
        random=new Random();
        renderer=new ShapeRenderer();
        this.cellSize=cellSize;
        this.width=width;
        this.height=height;
        mapa=new boolean[width][height];
        randomize();
    }
    public void randomize(){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                mapa[i][j]=true;
            }
        }
//        int x=random.nextInt(width);
//        int y=random.nextInt(height);
        mapa[0][0]=false;
        LinkedList<Point> points=new LinkedList<>();
        points.add(new Point(0,1));
        points.add(new Point(1,0));
        while (!points.isEmpty()){
            int index=random.nextInt(points.size());
//            int index=points.size()-1;
            Point p=points.get(index);
            points.remove(index);
            if(p.x<1||p.y<1||p.x>=width-1||p.y>=height-1||mapa[p.x][p.y]==false)continue;
//            int around=0;
//            if(p.x+1<width&&mapa[p.x+1][p.y]==false)around++;
//            if(p.y+1<height&&mapa[p.x][p.y+1]==false)around++;
//            if(p.x-1>=0&&mapa[p.x-1][p.y]==false)around++;
//            if(p.y-1>=0&&mapa[p.x][p.y-1]==false)around++;
//            System.out.println(around);
            if((!mapa[p.x + 1][p.y] && !mapa[p.x - 1][p.y])||
            (!mapa[p.x][p.y+1] && !mapa[p.x][p.y-1])){

            }else{
                mapa[p.x][p.y]=false;
                points.add(new Point(p.x+1,p.y));
                points.add(new Point(p.x-1,p.y));
                points.add(new Point(p.x,p.y+1));
                points.add(new Point(p.x,p.y-1));
            }
        }
    }
    public void print(){
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                if(mapa[i][j])
                    System.out.print("##");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    public void draw(){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                if(mapa[i][j])
                    renderer.rect(i*cellSize,j*cellSize,cellSize,cellSize);
            }
        }
        renderer.end();
    }
    public static void main(String[] args) {
        Game game=new Game(50,50,10);
        game.randomize();
        game.print();
    }
}
