package com.mygdx.game.scenes.panel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.scenes.Hud;

/**
 * Created by MichaelBond on 9/9/2016.
 */
public class LifeCounter extends Group {

    private static final Vector2 LABEL_POSITION = new Vector2(720, 510);

    private int life;
    private Label lifeLabel;


    public LifeCounter() {
        setTransform(false);
        initLifeLabel();
        this.life = 3;
        updateLifeLabel();
    }

    private void initLifeLabel() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = Hud.FONT;
        style.fontColor = new Color(0xff0000ff);
        this.lifeLabel = new Label("", style);
        this.lifeLabel.setWidth(260);
        this.lifeLabel.setPosition(LABEL_POSITION.x, LABEL_POSITION.y);
    }

    public void addLife(int value) {
        this.life += value;
        updateLifeLabel();
    }

    public void subdtractLife(int value) {
        this.life -= value;
        updateLifeLabel();
    }

    private void updateLifeLabel() {
        this.lifeLabel.setText("Life: " + this.life);
    }
}
