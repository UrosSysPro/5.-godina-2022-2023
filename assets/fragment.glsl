varying vec2 v_pos;
uniform vec2 mousePos;
uniform vec2 size;

void main(){
    vec2 pos=v_pos*size;

    float vidljivost=1.0-length(pos-mousePos)/200.0;

    gl_FragColor=vec4(vec3(vidljivost),1.0);
}