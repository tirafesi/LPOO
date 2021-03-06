package com.example.tiago.lpoo.Logic;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.tiago.lpoo.Layouts.GameLoopActivityLayout;

/**
 * A class that represents an Earth Spell
 */
public class EarthSpell extends Spell{

    //Attributes:

    /**
     * Cooldown in seconds!
     */
    private static final float COOLDOWN = (float) 2.0;

    /**
     * Cooldown in frames!!
     */
    public static int cooldown = 0;

    /**
     * TRUE if off cooldown, FALSE otherwise
     */
    public static boolean canCast = true;

    //Methods:

    /**
     * Default Constructor
     */
    public EarthSpell()
    {
        super();
    }

    /**
     * Constructor
     *
     * @param context Context
     * @param dps TRUE if coords are in dps, FALSE otherwise
     * @param x X coordinate
     * @param y Y coordinate
     * @param xSpeed Speed on X axis
     * @param ySpeed Speed on Y axis
     * @param spriteSheet Sprite Sheet
     * @param direction Direction
     */
    public EarthSpell(Context context, boolean dps, int x, int y, int xSpeed, int ySpeed, Bitmap spriteSheet, char direction) {
        super(context, dps, x, y, xSpeed, ySpeed, direction);
        switch (direction)
        {
            case 'N':
                state = new EarthCastingHorizontalState(this);
                break;
            case 'S':
                state = new EarthCastingHorizontalState(this);
                break;
            case 'E':
                state = new EarthCastingVerticalState(this);
                break;
            case 'W':
                state = new EarthCastingVerticalState(this);
                break;
            default:
                break;
        }
        initPosition(dps, x, y, xSpeed, ySpeed);
        cooldown = (int) COOLDOWN * GameLoopActivityLayout.UPS;
        canCast = false;
    }

    @Override
    protected void handleCollision(Monster monster) {
        //if monster intersects with earth wall, it can't move
        monster.setRooted(true);
    }
}
