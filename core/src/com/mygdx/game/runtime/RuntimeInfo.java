package com.mygdx.game.runtime;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.managment.LevelController;
import com.mygdx.game.sprites.frogs.active.Frog;

/**
 * Created by MichaelBond on 9/30/2016.
 */
public class RuntimeInfo {

    public int gameScore;
    public int gameLives;
    public int gameLevel;
    public float gameSpeed;
    public Array<Frog> activeFrogs;

    public RuntimeInfo(int score, int lives) {
        this.gameScore = score;
        this.gameLives = lives;
        this.gameLevel = LevelController.STARTING_LEVEL;
        this.gameSpeed = LevelController.STARTING_SPEED;
        this.activeFrogs = new Array<Frog>();
    }
}
