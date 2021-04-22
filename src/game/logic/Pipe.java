package game.logic;

import java.awt.*;

public class Pipe extends Entity {
    public static final float SPEED = 300;

    private boolean scored = false;

    public Pipe(float x, float y) {
        this.color = Color.GREEN.darker();
        this.x = x;
        this.y = y;
        this.WIDTH = 100;
        this.HEIGHT = 250;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    @Override
    public boolean checkCollision(Entity other) {
        float top = this.y - this.HEIGHT/2;
        float bottom = this.y + this.HEIGHT/2;

        return (this.x + this.WIDTH > other.x && this.x < other.x + other.WIDTH)
                && ((top > other.y) || (bottom < (other.y + other.HEIGHT)));
    }

    @Override
    public void drawEntity(Graphics g) {
        g.setColor(color);
        g.fillRect((int)x, 0, (int)WIDTH, (int)(this.y - HEIGHT/2));
        g.fillRect((int)x, (int)(this.y + HEIGHT/2), (int)WIDTH, 800);
    }

    @Override
    public void updateEntity() {
        x -=  SPEED * 0.033;
        if(x + WIDTH < 0){
            x += 1600;
            y = (float) (Math.random() * (575 - 225) + 225);
            scored = false;
        }
    }
}
