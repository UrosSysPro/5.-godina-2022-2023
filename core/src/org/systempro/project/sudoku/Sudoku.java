package org.systempro.project.sudoku;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.util.Scanner;

public class Sudoku {
    private int[][] mat;

    public Sudoku(String fileName){
        File file= Gdx.files.internal(fileName).file();
        mat=new int[9][9];
        try{
            Scanner scanner=new Scanner(file);
            for(int j=0;j<9;j++){
                for(int i=0;i<9;i++){
                    mat[i][j]=scanner.nextInt();
                }
            }
            scanner.close();
        }catch (Exception e){

        }
    }
    public boolean resi(){
        return resiR(0,0);
    }
    private boolean resiR(int x,int y){
        if(x>=9||y>=9)return true;

        int nextX=(x+1)%9;
        int nextY=y;
        if(x==8)nextY++;

        if(mat[x][y]!=0)
            return resiR(nextX,nextY);

        boolean[] mogucnosti=pronadjiMogucnosti(x,y);
        for(int i=0;i<mogucnosti.length;i++){
            if(mogucnosti[i]){
                mat[x][y]=i+1;
                boolean rez=resiR(nextX,nextY);
                if(rez)return true;
                mat[x][y]=0;
            }
        }
        return false;
    }
    private boolean[] pronadjiMogucnosti(int x,int y){
        boolean[] mogucnosti=new boolean[9];
        for(int i=0;i<9;i++)mogucnosti[i]=true;

        for(int i=0;i<9;i++){
           if(mat[x][i]!=0)mogucnosti[mat[x][i]-1]=false;
           if(mat[i][y]!=0)mogucnosti[mat[i][y]-1]=false;
        }
        x-=x%3;
        y-=y%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int polje=mat[x+i][y+j];
                if(polje!=0)mogucnosti[polje-1]=false;
            }
        }
        return mogucnosti;
    }
    public void print(){
        for(int j=0;j<9;j++){
            for(int i=0;i<9;i++){
                System.out.print(" "+mat[i][j]);
            }
            System.out.println();
        }
    }

}
