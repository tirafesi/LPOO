package com.example.tiago.lpoo.Logic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.tiago.lpoo.Layouts.GameLoopActivityLayout;
import com.example.tiago.lpoo.R;

/**
 * A class that represents the Water spell's active state
 */
public class WaterActiveLeftState implements SpellState {

    //Attributes:

    /**
     * How many frames passed since state started
     */
    private int frameCount;

    /**
     * Speed of the animation
     */
    private static final int FPS = 10;

    /**
     * Order of the frames (index) of the animation
     */
    private static final int[] FRAMES = new int[]{13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

    /**
     * Number of rows of animation spriteSheet
     */
    private static final int ROWS = 8;

    /**
     * Number of columns of animation spriteSheet
     */
    private static final int COLS = 4;

    /**
     * Sprite sheet of Animation
     */
    private static Bitmap spriteSheet;

    /**
     * How long this state lasts (in frames)
     */
    private static final float STATE_DURATION = FRAMES.length * GameLoopActivityLayout.UPS / FPS;


    //Methods:

    /**
     * Constructor
     *
     * @param spell Spell
     */
    public WaterActiveLeftState(Spell spell) {
        //spriteSheet is only initialized once!
        if (spriteSheet == null)
            spriteSheet = BitmapFactory.decodeResource(spell.context.getResources(), R.drawable.water_spell);
        spell.sprite = new Sprite(spriteSheet, ROWS, COLS);
        enter(spell);
        frameCount = 0;
    }


    @Override
    public void enter(Spell spell) {
        //set correct animation
        spell.sprite.init(FPS, FRAMES);
    }

    @Override
    public SpellState update(Spell spell) {
        //update frameCount
        frameCount++;
        //if the entire animation as been played
        if (frameCount > STATE_DURATION)
            spell.setActive(false);
        return null;
    }
}
