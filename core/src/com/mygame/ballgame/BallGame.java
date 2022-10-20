package com.mygame.ballgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BallGame extends ApplicationAdapter {

    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;



    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(250, 150, 15, 5, 5);
        paddle = new Paddle(0, 10, 70, 10);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.update();
        ball.draw(shape);
        paddle.draw(shape);
        paddle.update();
        shape.end();
    }
}
