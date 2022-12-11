package org.systempro.project.maze;

public class Point {

    public int x,y;
    public Point(int x,int y){
        set(x,y);
    }
    public Point(){
        set(0,0);
    }
    public void set(int x,int y){
        this.x=x;
        this.y=y;
    }
}
