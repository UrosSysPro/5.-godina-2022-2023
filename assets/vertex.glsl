attribute vec2 pos;

varying vec2 v_pos;

void main(){
    vec2 pozicija=pos;
    pozicija/=2.0;
    pozicija+=0.5;
    pozicija.y=1.0-pozicija.y;
    v_pos=pozicija;
    gl_Position=vec4(pos,0.0,1.0);
}