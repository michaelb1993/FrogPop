package com.mygdx.game.sprites.frogs;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.animation.Animation;
import com.mygdx.game.managment.LevelController;
import com.mygdx.game.runtime.RuntimeInfo;
import com.mygdx.game.scenes.Hud;

import java.util.Random;

/**
 * This class represents a regular-frog.
 * It has no special abilities, and it's profit and penalty values are the default ones:
 *  (+1 and -1 respectively).
 *
 * Created by MichaelBond on 9/8/2016.
 */
public class HealthFrog extends Frog {

    private static final int FROG_SCORE_PROFIT_VALUE = 2;
    private static final int FROG_LIFE_PROFIT_VALUE = 1;
    private static final int FROG_LIFE_PENALTY_VALUE = -1;

    private final Texture healthFrogAnimationTextures [] = {
            new Texture("Frog/0y.png"),
            new Texture("Frog/1y.png"),
            new Texture("Frog/2y.png"),
            new Texture("Frog/3y.png"),
            new Texture("Frog/0y.png"),
            new Texture("Frog/eye2y.png"),
            new Texture("Frog/eye3y.png"),
            new Texture("Frog/eye4y.png")
    };

    private Animation animation;


    public HealthFrog() {
        this.animation = new Animation(healthFrogAnimationTextures);
        setSize(healthFrogAnimationTextures[0].getWidth(), healthFrogAnimationTextures[0].getHeight());
    }

    @Override
    public void update(float deltaTime) {
        this.animation.update(deltaTime);
        this.lifeTime += deltaTime * this.runtimeInfo.gameSpeed * 1.2f;
    }

    @Override
    public void dispose() {
        // TODO (check if we want this behavior).
        for (Texture texture : this.healthFrogAnimationTextures) {
            texture.dispose();
        }
    }

    @Override
    public void touched() {
        this.isKilled = true;
    }

    @Override
    public void onDeath() {
        if (isKilled()) {
            Hud.getInstance().getScoreCounter().addScore(FROG_SCORE_PROFIT_VALUE);
            Hud.getInstance().getLifeCounter().addLife(FROG_LIFE_PROFIT_VALUE);
        }
        else {
            Hud.getInstance().getLifeCounter().addLife(FROG_LIFE_PENALTY_VALUE);
            Gdx.input.vibrate(500);
        }
    }

    @Override
    public void init(RuntimeInfo runtimeInfo, float positionX, float positionY) {
        super.defaultInit(runtimeInfo, positionX, positionY);

        this.frogRectangle = new Rectangle(
                this.position.x-20, this.position.y-35,
                getWidth() + 40, getHeight() + 35);
    }

    @Override
    public void reset() {
        super.defaultReset();
        this.animation.reset();
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(getFrogTexture(), this.position.x, this.position.y,
                0, 0, 100, 100-(int)(((FROG_MAX_LIFE_TIME - this.lifeTime)*100)/(FROG_MAX_LIFE_TIME)));
    }

    public Texture getFrogTexture() {
        return this.animation.getFrame();
    }

}
