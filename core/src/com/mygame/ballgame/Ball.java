package com.mygame.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball  {

    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

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
        if (x -size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y - size < 0 || y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
        //shape.rect(x-size,y-size,size*2,size*2); //ballHitbox
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            color = Color.GREEN;
        } else {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        if (paddle.x + paddle.width >= x - size && paddle.x <= x + size && paddle.y <= y + size && paddle.y + paddle.height >= y - size) {
            return true;
        } else {
            return false;
        }
    }


}
