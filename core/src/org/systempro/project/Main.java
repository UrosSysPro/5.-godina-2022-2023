package org.systempro.project;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.systempro.project.game.TestScreen;
import org.systempro.project.snake.GameScreen;

public class Main extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}

}
