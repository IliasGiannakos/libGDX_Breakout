package com.mygame.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Paddle extends Rectangle {

    int x;
    int y;
    int width;
    int height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        x = Gdx.input.getX()-width/2;
        y = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (x   < 0) {
            x = 0;
        }
        if (x + width  >= Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth()-width;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
