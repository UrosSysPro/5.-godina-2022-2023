package org.systempro.project;

import com.badlogic.gdx.Game;
import org.systempro.project.shader2.TestScreen;

public class Main extends Game {

	@Override
	public void create() {
		setScreen(new TestScreen());
	}

}
