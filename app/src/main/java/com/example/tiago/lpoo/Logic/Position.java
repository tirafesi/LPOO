package com.example.tiago.lpoo.Logic;

import android.graphics.Rect;

/**
 * A class (works like a C++ struct) that represents the Coordinates of an Object on the screen (in dps)
 */
public class Position {

    //Attributes:

    /**
     * The hitbox of an object and its coordinates (matches the object's sprites dim) (in pixels != dps)
     */
    public Rect position;

    /**
     * Speed along the X axis (in pixels != dps)
     */
    public int xSpeed;

    /**
     * Speed along the Y axis (in pixels != dps)
     */
    public int ySpeed;

    //Methods:

    /**
     * Default Constructor
     */
    public Position() {
        this(new Rect(), 0, 0);
    }

    /**
     * Constructor
     *
     * @param position Hitbox of the object (in pixels != dps)
     * @param xSpeed   Speed along the X axis (in pixels != dps)
     * @param ySpeed   Speed along the Y axis (in pixels != dps)
     */
    public Position(Rect position, int xSpeed, int ySpeed) {
        this.position = position;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /**
     * Constructor
     *
     * @param pos Position to copy
     */
    public Position(Position pos) {
        this.position = pos.position;
        this.xSpeed = pos.xSpeed;
        this.ySpeed = pos.ySpeed;
    }

    /**
     * Updates current position according to its axis speed
     */
    public void update() {
        position.offset(xSpeed, ySpeed);
    }

    /**
     * Checks if this Position intersects with given Position
     *
     * @param position2 Position to check intersection with
     * @return TRUE if they intersect, FALSE otherwise
     */
    public boolean intersects(Position position2) {
        return (position.intersects(position, position2.position));
    }
}
