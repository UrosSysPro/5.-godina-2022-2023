package org.systempro.project.minesweaper;

public class Polje {
    boolean isMine;
    int minesAround;
    boolean revealed;
    public Polje(){
        isMine=false;
        minesAround=0;
        revealed=false;
    }
}
