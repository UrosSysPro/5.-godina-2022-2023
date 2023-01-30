package org.systempro.project.shader2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.ScreenUtils;
import org.systempro.project.BasicScreen;

public class TestScreen extends BasicScreen {
    Mesh mesh;
    ShaderProgram shader;
    Texture texture;

    @Override
    public void show() {
        mesh=new Mesh(true,4,6,
            new VertexAttribute(VertexAttributes.Usage.Position,2,"pos")
        );
        mesh.setVertices(new float[]{
            -1,-1,
             1,-1,
             1, 1,
            -1, 1,
        });
        mesh.setIndices(new short[]{
            0,1,2,
            0,2,3
        });

        ShaderProgram.pedantic=false;
        String vertex= Gdx.files.internal("shader2/vertex.glsl").readString();
        String fragment= Gdx.files.internal("shader2/fragment.glsl").readString();
        shader=new ShaderProgram(vertex,fragment);

        texture=new Texture("tilemap.png");

        if(!shader.isCompiled()){
            System.out.println(shader.getLog());
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        shader.bind();
        texture.bind(0);
        shader.setUniformi("tilemap",0);
        mesh.render(shader, GL20.GL_TRIANGLES);
    }
}
