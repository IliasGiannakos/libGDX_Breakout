package com.mygame.ballgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BallGame extends ApplicationAdapter {

    ShapeRenderer shape;
    Ball ball;



    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(250, 150, 20, 5, 5);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.update();
        ball.draw(shape);
        shape.end();
    }
}
