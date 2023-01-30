attribute vec2 pos;

varying vec2 v_pos;

void main(){
    vec2 position=(pos+1.0)/2.0;
    position.y=1.0-position.y;
    v_pos=position;

    gl_Position=vec4(pos,0.0,1.0);
}