package org.systempro.project.bfs;

import org.systempro.project.BasicScreen;

public class TestScreen extends BasicScreen {

    public Bfs bfs;

    @Override
    public void show() {
        bfs=new Bfs("l.txt");
        bfs.print();
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void dispose() {

    }
}
