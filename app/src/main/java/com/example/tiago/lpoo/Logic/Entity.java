package com.example.tiago.lpoo.Logic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

/**
 * A class that represents a Entity (monster, wizard, etc)
 */
public abstract class Entity {

    //Attributes:

    /**
     * Coordinates of the Entity on the screen, its hitbox and axis speed (in pixels != dps)
     */
    protected Position position;

    /**
     * Sprite containing the Object's animations
     */
    protected Sprite sprite;

    /**
     * Context
     */
    protected Context context;

    //Methods:

    /**
     * Constructor
     *
     * @param context Context
     */
    public Entity(Context context) {
        this.context = context;
        sprite = null;
        position = null;
    }

    /**
     * Default Constructor
     */
    public Entity() {
        this(null);
    }

    protected void initPosition(boolean dps, int x, int y, int xSpeed, int ySpeed) {
        if (dps) {
            int x_dps = toPixels(x);
            int y_dps = toPixels(y);
            int xSpeed_dps = toPixels(xSpeed);
            int ySpeed_dps = toPixels(ySpeed);
            Log.w("a", "x_dps: " + x_dps + ", y_dps: " + y_dps);
            Log.w("a", "xSpeed_dps: " + xSpeed_dps + ", ySpeed_dps: " + ySpeed_dps);
            Log.w("a", "spriteWidth: "+ sprite.getWidth() + ", spriteHeight: " + sprite.getSpriteHeight());
            position = new Position(new Rect(x_dps, y_dps, x_dps + sprite.getSpriteWidth(), y_dps + sprite.getSpriteHeight()), xSpeed_dps, ySpeed_dps);
        } else
            position = new Position(new Rect(x, y, x + sprite.getSpriteWidth(), y + sprite.getSpriteHeight()), xSpeed, ySpeed);
    }

    /**
     * Convert from density pixels to pixels
     *
     * @param dps Density Pixels to convert
     * @return Dps converted to pixels
     */
    protected int toPixels(float dps) {
        return (int) (dps * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * Render this object onto the screen
     *
     * @param canvas Canvas to draw to
     */
    public void render(Canvas canvas) {
        sprite.render(canvas, position.position);
    }

    /**
     * Updates current X and Y positions according to its speed
     */
    public void update() {
        position.update();
        sprite.update();
    }

    /**
     * Getter
     *
     * @return Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter
     *
     * @param position Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
