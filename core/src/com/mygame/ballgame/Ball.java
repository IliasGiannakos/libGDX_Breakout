package com.mygame.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {

    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    public boolean outOfBounds = false;


    Color color = Color.WHITE;


    //    ball obj constructor
    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if ( y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        if (y + size < 0) {
            outOfBounds = true;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);

    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Block block) {
        if (collidesWith(block)) {
           block.destroyed = true;
            ySpeed = -ySpeed;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        if (paddle.x + paddle.width >= x - size && paddle.x <= x + size && paddle.y <= y + size && paddle.y + paddle.height >= y - size) {
            return true;
        } else {
            return false;
        }
    }

    private boolean collidesWith(Block block) {
        if (block.x + block.width >= x - size && block.x <= x + size && block.y <= y + size && block.y + block.height >= y - size) {
            return true;
        } else {
            return false;
        }
    }


}