package com.mygame.ballgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class BallGame extends ApplicationAdapter {

	ShapeRenderer shape;

	@Override
	public void create() {
		shape = new ShapeRenderer();
	}

	@Override
	public void render() {
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.circle(50,50,50);
		shape.setColor(1,0.7f,0,1);
		shape.end();
	}
}
