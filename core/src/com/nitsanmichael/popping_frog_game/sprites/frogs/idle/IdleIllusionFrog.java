package com.nitsanmichael.popping_frog_game.sprites.frogs.idle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.nitsanmichael.popping_frog_game.animation.Animation;
import com.nitsanmichael.popping_frog_game.assets.AssetController;
import com.nitsanmichael.popping_frog_game.assets.Assets;

/**
 * Created by MichaelBond on 10/10/2016.
 */
public class IdleIllusionFrog extends IdleFrog {

    private Animation animation;
    private Vector2 position;


    public IdleIllusionFrog(AssetController assetController, Vector2 position) {
        this.animation = assetController.getAnimation(Assets.ILLUSION_FROG_ANIMATION, 0.15f);
        this.position = position;
    }

    @Override
    public void update(float deltaTime) {
        this.animation.update(deltaTime);
        Texture frame = this.animation.getFrame();
        setSize(frame.getWidth(), frame.getHeight());
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(this.animation.getFrame(), this.position.x, this.position.y);
    }
}
