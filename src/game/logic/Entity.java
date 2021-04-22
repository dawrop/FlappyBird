package game.logic;

import java.awt.*;

public abstract class Entity {
    protected float x, y, WIDTH, HEIGHT;
    protected Color color;

    public void drawEntity(Graphics g){
        g.setColor(color);
        g.fillRect((int)x, (int)y, (int)WIDTH, (int)HEIGHT);
    }

    public void updateEntity(){

    }

    public boolean checkCollision(Entity other){
        return this.x + this.WIDTH > other.x && this.x < other.x + other.WIDTH
        &&     this.y + this.HEIGHT > other.y && this.y < other.y + other.HEIGHT;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(float WIDTH) {
        this.WIDTH = WIDTH;
    }

    public float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
