package org.systempro.project.maze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Maze {
    public int width,height;
    private int[][] mat;
    int cellSize;

    public Maze(String fileName){
        File file= Gdx.files.internal(fileName).file();
        System.out.println(file.getAbsolutePath());
        try{
            Scanner scanner=new Scanner(file);
            width=scanner.nextInt();
            height=scanner.nextInt();

            mat=new int[width][height];

            for(int j=0;j<height;j++){
                for(int i=0;i<width;i++){
                    mat[i][j]=scanner.nextInt();
                }
            }
            scanner.close();
            cellSize=Gdx.graphics.getHeight()/height;
        }catch (Exception e){
            System.out.println("fajl ne postoji");
            e.printStackTrace();
        }
    }
    public void print(){
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                System.out.print(" "+mat[i][j]);
            }
            System.out.println();
        }
    }
    public void solveBfs(int x,int y){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                mat[i][j]=mat[i][j]==-2?-2:-1;
            }
        }
        LinkedList<Point> list=new LinkedList<>();
        mat[x][y]=0;
        list.addFirst(new Point(x,y));
        while (!list.isEmpty()){
            Point pos=list.getFirst();
            list.removeFirst();
            int trenutno=mat[pos.x][pos.y];
            if(pos.x-1>=0&&(mat[pos.x-1][pos.y]==-1||mat[pos.x-1][pos.y]>trenutno+1)){
                mat[pos.x-1][pos.y]=trenutno+1;
                list.addLast(new Point(pos.x-1,pos.y));
            }
            if(pos.x+1<width&&(mat[pos.x+1][pos.y]==-1||mat[pos.x+1][pos.y]>trenutno+1)){
                mat[pos.x+1][pos.y]=trenutno+1;
                list.addLast(new Point(pos.x+1,pos.y));
            }
            if(pos.y-1>=0&&(mat[pos.x][pos.y-1]==-1||mat[pos.x][pos.y-1]>trenutno+1)){
                mat[pos.x][pos.y-1]=trenutno+1;
                list.addLast(new Point(pos.x,pos.y-1));
            }
            if(pos.y+1<height&&(mat[pos.x][pos.y+1]==-1||mat[pos.x][pos.y+1]>trenutno+1)){
                mat[pos.x][pos.y+1]=trenutno+1;
                list.addLast(new Point(pos.x,pos.y+1));
            }
        }
    }
    public void solveDfs(int x,int y){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                mat[i][j]=mat[i][j]==-2?-2:-1;
            }
        }
        Stack<Point> stack=new Stack<>();
        mat[x][y]=0;
        stack.push(new Point(x,y));
        while (!stack.isEmpty()){
            Point pos=stack.pop();
            int trenutno=mat[pos.x][pos.y];
            if(pos.x-1>=0&&(mat[pos.x-1][pos.y]==-1||mat[pos.x-1][pos.y]>trenutno+1)){
                mat[pos.x-1][pos.y]=trenutno+1;
                stack.push(new Point(pos.x-1,pos.y));
            }
            if(pos.x+1<width&&(mat[pos.x+1][pos.y]==-1||mat[pos.x+1][pos.y]>trenutno+1)){
                mat[pos.x+1][pos.y]=trenutno+1;
                stack.push(new Point(pos.x+1,pos.y));
            }
            if(pos.y-1>=0&&(mat[pos.x][pos.y-1]==-1||mat[pos.x][pos.y-1]>trenutno+1)){
                mat[pos.x][pos.y-1]=trenutno+1;
                stack.push(new Point(pos.x,pos.y-1));
            }
            if(pos.y+1<height&&(mat[pos.x][pos.y+1]==-1||mat[pos.x][pos.y+1]>trenutno+1)){
                mat[pos.x][pos.y+1]=trenutno+1;
                stack.push(new Point(pos.x,pos.y+1));
            }
        }
    }
    public void toggleBlock(int x,int y){
        mat[x][y]=mat[x][y]==-2?-1:-2;
    }
    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                float alpha=(float) mat[i][j]/(width);
                if(mat[i][j]!=-2 && mat[i][j]!=-1)
                    renderer.setColor(
                        new Color(
                            alpha*Color.LIME.r+(1-alpha)*Color.CORAL.r,
                            alpha*Color.LIME.g+(1-alpha)*Color.CORAL.g,
                            alpha*Color.LIME.b+(1-alpha)*Color.CORAL.b,
                            1
                        )
                    );
                else if(mat[i][j]==-2)
                    renderer.setColor(Color.BLACK);
                else
                    renderer.setColor(Color.WHITE);

                int height=Gdx.graphics.getHeight();
                renderer.rect(i*cellSize,height-(j+1)*cellSize,cellSize,cellSize);
            }
        }
        renderer.end();
    }
}
