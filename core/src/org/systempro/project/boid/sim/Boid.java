package org.systempro.project.boid.sim;

import com.badlogic.gdx.math.Vector2;

import javax.naming.Name;
import java.util.ArrayList;

public class Boid {
    public static float vidljivost=100;

    public float x,y;
    public float vx,vy;

    public Boid(float x,float y,float vx,float vy){
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
    }
    public void update(float width, float height, ArrayList<Boid> niz){
        x+=vx;
        y+=vy;
        if(x<0)x=width;
        if(x>width)x=0;
        if(y<0)y=height;
        if(y>height)y=0;


    }
    public Vector2 separation(ArrayList<Boid> niz){
        Vector2 sep=new Vector2(0,0);
        int n=0;
        for(Boid b:niz){
            if(b==this)continue;
            float r=razdaljina(x,y,b.x,b.y);
            if(r>vidljivost)continue;
            Vector2 diff=new Vector2(x-b.x,y-b.y);
            diff.nor();
            diff.x/=r;
            diff.y/=r;
            sep.add(diff);
            n++;
        }
        if(n>0){
            sep.x/=n;
            sep.y/=n;
        }
        Vector2 steer=new Vector2(sep.x-vx,sep.y-vy);
        return sep;
    }
    public float razdaljina(float x1,float y1,float x2,float y2){
        return (float) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
