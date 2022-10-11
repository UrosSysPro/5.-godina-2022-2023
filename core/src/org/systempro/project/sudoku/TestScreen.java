package org.systempro.project.sudoku;

import org.systempro.project.BasicScreen;

public class TestScreen extends BasicScreen {
    public Sudoku s;
    @Override
    public void show() {
        s=new Sudoku("sudoku.txt");
        s.print();
        boolean rez=s.resi();
        if(rez)
            System.out.println("reseno");
        else
            System.out.println("ne postoji resenje");
        s.print();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
