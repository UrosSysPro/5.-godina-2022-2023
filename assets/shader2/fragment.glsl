varying vec2 v_pos;
uniform sampler2D tilemap;

vec2 size=vec2(800,600);

void main(){
    gl_FragColor=texture2D(tilemap,v_pos);//+vec4(v_pos,0.0,1.0);
}