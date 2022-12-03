package org.systempro.project.boid.sim;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    private Random random;
    private ArrayList<Boid> curr,next;
    private float width,height;
    public Simulation(float width,float height){
        this.width=width;
        this.height=height;
        random=new Random();
        curr=new ArrayList<>();
        next=new ArrayList<>();
    }

    public void add(float x,float y){
        float vx=random.nextFloat()*6-3;
        float vy=random.nextFloat()*6-3;
        curr.add(new Boid(x,y,vx,vy));
        next.add(new Boid(x,y,vx,vy));
    }

    public void update(){
        for(int i=0;i<next.size();i++){
            Boid novi=next.get(i);
            Boid stari=next.get(i);
            novi.x=stari.x;
            novi.y=stari.y;
            novi.vx=stari.vx;
            novi.vy=stari.vy;
            novi.update(width,height,curr,next);
        }
        ArrayList<Boid>p;
        p=curr;
        curr=next;
        next=p;
    }
    public void draw(ShapeRenderer renderer){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.LIME);
        for(Boid b:curr){
            b.draw(renderer);
        }
        renderer.end();
    }
}
