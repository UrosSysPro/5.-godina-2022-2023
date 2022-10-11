package org.systempro.project.bfs;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.util.Scanner;

public class Bfs {
    private int width,height;
    private int[][] mat;

    public Bfs(String fileName){

        try{
            File file= Gdx.files.internal(fileName).file();
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
}
