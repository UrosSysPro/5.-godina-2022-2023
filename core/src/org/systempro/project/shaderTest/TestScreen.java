package org.systempro.project.shaderTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class TestScreen implements Screen {

    Mesh mesh;
    ShaderProgram shader;


    @Override
    public void show() {
        mesh=new Mesh(true,4,6,
            new VertexAttribute(Usage.Position,2,"pos")
        );
        mesh.setVertices(new float[]{
           -1, 1,
            1, 1,
            1,-1,
           -1,-1,
        });
        mesh.setIndices(new short[]{
            0,1,3,
            1,2,3
        });
        String vertex= Gdx.files.internal("vertex.glsl").readString();
        String fragment= Gdx.files.internal("fragment.glsl").readString();
        ShaderProgram.pedantic=false;
        shader=new ShaderProgram(vertex,fragment);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        int x=Gdx.input.getX();
        int y=Gdx.input.getY();
        int width=Gdx.graphics.getWidth();
        int height=Gdx.graphics.getHeight();

        shader.bind();
        shader.setUniformf("mousePos",new Vector2(x,y));
        shader.setUniformf("size",new Vector2(width,height));
        mesh.render(shader, GL20.GL_TRIANGLES);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
