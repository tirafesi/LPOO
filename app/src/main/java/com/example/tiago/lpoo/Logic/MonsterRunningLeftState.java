package com.example.tiago.lpoo.Logic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.tiago.lpoo.R;

/**
 * A class that represents the Monster running left state
 */
public class MonsterRunningLeftState implements MonsterState {

    //Attributes:

    /**
     * Speed of the animation
     */
    private static final int FPS = 8;

    /**
     * Animation frames (ordered by index)
     */
    private static final int[] FRAMES = new int[]{9, 8, 11, 10, 13, 12, 15, 14};

    /**
     * Number of rows of animation spriteSheet
     */
    private static final int ROWS = 8;

    /**
     * Number of columns of animation spriteSheet
     */
    private static final int COLS = 2;

    /**
     * Sprite sheet of Animation
     */
    private static Bitmap spriteSheet;

    //Methods:

    /**
     * Constructor
     *
     * @param monster Monster
     */
    public MonsterRunningLeftState(Monster monster) {
        //spriteSheet is only initialized once!
        if (spriteSheet == null)
            spriteSheet = BitmapFactory.decodeResource(monster.context.getResources(), R.drawable.monster);
        monster.sprite = new Sprite(spriteSheet, ROWS, COLS);
        enter(monster);
    }


    @Override
    public void enter(Monster monster) {
        //set correct animation
        monster.sprite.init(FPS, FRAMES);
    }

    @Override
    public MonsterState update(Monster monster) {

        return null;
    }
}
