package com.mygdx.game.scenes.panel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.scenes.Hud;

/**
 * Created by MichaelBond on 9/9/2016.
 */
public class LevelCounter extends Group {

    private static final Vector2 LABEL_POSITION = new Vector2(25, 495);

    private int level;
    private Label levelLabel;


    public LevelCounter() {
        setTransform(false);
        initLevelLabel();
        this.level = 0;
        updateLevelLabel();
    }

    private void initLevelLabel() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = Hud.FONT;
        style.fontColor = new Color(0x000000ff);
        this.levelLabel = new Label("", style);
        this.levelLabel.setWidth(260);
        this.levelLabel.setPosition(LABEL_POSITION.x, LABEL_POSITION.y);
    }

    public void advance() {
        this.level += 1;
        updateLevelLabel();
    }

    private void updateLevelLabel() {
        this.levelLabel.setText("Level: " + this.level);
    }
}
