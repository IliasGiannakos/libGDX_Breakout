package com.mygame.ballgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class BallGame extends ApplicationAdapter {

    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;
    ArrayList<Block> blocks = new ArrayList<>();
    SpriteBatch batch = new SpriteBatch();



    @Override

    public void create() {
        int blockHeight = 20;
        int blockWidth = 63;
        shape = new ShapeRenderer();
        ball = new Ball(300, 250, 10, 5, 5);
        paddle = new Paddle(0, 10, 70, 10);
        for (int y = Gdx.graphics.getHeight()/2; y <Gdx.graphics.getHeight(); y += blockHeight +10) {
            for (int x =0; x < Gdx.graphics.getWidth(); x += blockWidth +10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.checkCollision(paddle);
        for (Block block : blocks) {
            block.draw(shape);
        }

        for (Block b : blocks) {
            b.draw(shape);
            ball.checkCollision(b);
        }

        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.destroyed) {
                blocks.remove(b);
                i--;
            }
        }
        
        ball.update();
        ball.draw(shape);
        paddle.draw(shape);
        paddle.update();
        shape.end();
    }
}
