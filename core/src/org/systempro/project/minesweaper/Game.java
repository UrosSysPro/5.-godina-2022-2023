package org.systempro.project.minesweaper;


public class Game {
    int width,height,cellSize,brojMina;
    public Polje[][] tabela;
    public Game(int width,int height,int cellSize,int brojMina){
        this.width=width;
        this.height=height;
        this.cellSize=cellSize;
        this.brojMina=brojMina;
        tabela=new Polje[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                tabela[i][j]=new Polje();
            }
        }
    }

    public void input(){

    }
    public void update(){

    }
    public void draw(){

    }
}
