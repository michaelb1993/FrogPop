package com.mygdx.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.animation.Animation;
import com.mygdx.game.config.Config;

/**
 * Created by MichaelBond on 9/27/2016.
 */
public class AssetController {

    // Public members.
    public Config config;
    // Private members.
    private AssetManager manager;

    public AssetController() {
        this.manager = new AssetManager();
    }


    public void loadAll() {
        // todo
        loadMusics();
        loadSounds();
        loadTextures();
        this.manager.finishLoading();
        // Load config.
        this.config = new Config();
        this.config.load();
    }

    private void loadMusics() {
        for (String fileName : Assets.MUSIC_FILES) {
            this.manager.load(fileName, Music.class);
        }
    }

    private void loadSounds() {
        for (String fileName : Assets.SOUND_FILES) {
            this.manager.load(fileName, Sound.class);
        }
    }

    private void loadTextures() {
        for (String fileName : Assets.TEXTURE_FILES) {
            this.manager.load(fileName, Texture.class);
        }
    }

    public <T> T get(String fileName) {
        return this.manager.get(fileName);
    }

    public Animation getAnimation(String [] animationTexturesNames) {
        return new Animation(getFrames(animationTexturesNames));
    }

    public Animation getAnimation(String [] animationTexturesNames, float frameTime) {
        return new Animation(getFrames(animationTexturesNames), frameTime);
    }

    private Array<Texture> getFrames(String [] animationTexturesNames) {
        Array<Texture> frames = new Array<Texture>();
        for (String textureName : animationTexturesNames) {
            Texture frame = get(textureName);
            frames.add(frame);
        }
        return frames;
    }

    public void unload(String fileName) {
        this.manager.unload(fileName);
    }

    public void clearAll() {
        this.manager.clear();
    }
}
