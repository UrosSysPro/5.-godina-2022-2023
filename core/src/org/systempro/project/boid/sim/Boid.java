package org.systempro.project.boid.sim;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import javax.naming.Name;
import java.util.ArrayList;

public class Boid {
    public static float vidljivost=100;

    public float x,y;
    public float vx,vy;
    public static float maxSpeed=3;
    public static float maxForce=0.05f;

    public Boid(float x,float y,float vx,float vy){
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
    }
    public void update(float width, float height,ArrayList<Boid> curr,ArrayList<Boid> next){
        //promeni brzina u zavisnosti od ostalih
        Vector2 sep=separation(curr,next);
        Vector2 a=align(curr,next);
//        vx+=sep.x;
//        vy+=sep.y;
//        vx+=a.x;
//        vy+=a.y;
        x+=vx;
        y+=vy;
        if(x<0)x=width;
        if(x>width)x=0;
        if(y<0)y=height;
        if(y>height)y=0;
    }
    public Vector2 separation(ArrayList<Boid> curr,ArrayList<Boid> next){
        Vector2 sep=new Vector2(0,0);
        int n=0;
        for(int i=0;i<curr.size();i++){
            if(next.get(i)==this)continue;
            Boid b=curr.get(i);
            float r=razdaljina(x,y,b.x,b.y);
            if(r==0&&r>vidljivost)continue;
            Vector2 diff=new Vector2(x-b.x,y-b.y);
            diff.nor();
            diff.x*=vidljivost/r;
            diff.y*=vidljivost/r;
            sep.add(diff);
            n++;
        }
        if(n>0){
            sep.x/=n;
            sep.y/=n;
        }
        if(sep.len()>0){
            sep.nor();
            sep.x*=maxSpeed;
            sep.y*=maxSpeed;
            sep.x-=vx;
            sep.y-=vy;
            sep.limit(maxForce);
        }
        return sep;
    }

    public Vector2 align(ArrayList<Boid> curr,ArrayList<Boid> next){
        Vector2 sum=new Vector2(0,0);
        int n=0;
        for(int i=0;i<curr.size();i++){
            if(next.get(i)==this)continue;
            Boid b=curr.get(i);
            float d=razdaljina(x,y,b.x,b.y);
            if(d>vidljivost)continue;
            sum.add(b.vx,b.vy);
            n++;
        }
        if(n==0){
            return sum;
        }else{
            sum.nor();
            sum.x*=maxSpeed;
            sum.y*=maxSpeed;
            sum.sub(vx,vy);
            sum.limit(maxForce);
            return sum;
        }

    }
    public float razdaljina(float x1,float y1,float x2,float y2){
        return (float) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public void draw(ShapeRenderer renderer){
        renderer.circle(x,y,3);
    }
}
