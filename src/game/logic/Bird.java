package game.logic;

import java.awt.*;

public class Bird extends Entity{
    protected float yVelocity, gravity;

    public Bird(float x, float y) {
        this.color = Color.RED;
        this.x = x;
        this.y = y;
        this.WIDTH = 40;
        this.HEIGHT = 40;
        this.yVelocity = 0;
        this.gravity = 1500;
    }

    @Override
    public void drawEntity(Graphics g) {
        super.drawEntity(g);
    }

    @Override
    public void updateEntity() {
        yVelocity += gravity * 0.033;
        y += yVelocity * 0.033;
    }

    public void jump() {
        yVelocity = -700;
    }
}
