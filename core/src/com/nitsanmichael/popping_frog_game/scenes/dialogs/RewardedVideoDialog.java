package com.nitsanmichael.popping_frog_game.scenes.dialogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nitsanmichael.popping_frog_game.adds.AdsController;
import com.nitsanmichael.popping_frog_game.assets.AssetController;
import com.nitsanmichael.popping_frog_game.assets.Assets;
import com.nitsanmichael.popping_frog_game.runtime.RuntimeInfo;
import com.nitsanmichael.popping_frog_game.scenes.ToggleButton;
import com.nitsanmichael.popping_frog_game.scenes.ToggleButtonListener;
import com.nitsanmichael.popping_frog_game.scenes.events.MessageEventListener;
import com.nitsanmichael.popping_frog_game.states.StateTracker;


/**
 * Created by MichaelBond on 10/27/2016.
 */
public class RewardedVideoDialog implements Disposable {

    // Dialog show time in seconds.
    private static final int SHOW_TIME = 5;
    private static final float COUNTDOWN_SPEED = 0.8f;

    private enum CountdownState { COUNTING, FINISHED, PLAYING_VIDEO, EMPTY }

    private AdsController adsController;
    private RuntimeInfo runtimeInfo;
    private Label timeLabel;
    private Stage stage;
    private float timeLeft;
    private CountdownState state;


    public RewardedVideoDialog(AssetController assetController, AdsController adsController,
                                Viewport viewport, Batch batch, RuntimeInfo runtimeInfo) {
        this.timeLeft = SHOW_TIME;
        this.state = CountdownState.COUNTING;
        this.adsController = adsController;
        this.runtimeInfo = runtimeInfo;

        // Rewarded video button.
        Texture rewardedReplayIcon = assetController.get(Assets.REWARDED_REPLAY_ICON);
        Texture rewardedReplayPressedIcon = assetController.get(Assets.REWARDED_REPLAY_PRESSED_ICON);
        final ToggleButton rewardedReplayButton = new ToggleButton(
                    new Image(rewardedReplayIcon), new Image(rewardedReplayPressedIcon));
        rewardedReplayButton.setSize(250, 150);
        rewardedReplayButton.setPosition(265, 220);
        rewardedReplayButton.addListener(new MessageEventListener() {
            @Override
            public void receivedMessage(int message, Actor actor) {
                if (actor != rewardedReplayButton || message != ToggleButtonListener.ON_TOUCH_UP ||
                            CountdownState.FINISHED == state) {
                    return;
                }
                playRewardingVideo();
            }
        });

        // X button.
        Texture xIcon = assetController.get(Assets.X_ICON);
        Texture xPressedIcon = assetController.get(Assets.X_PRESSED_ICON);
        final ToggleButton xButton = new ToggleButton(
                    new Image(xIcon), new Image(xPressedIcon));
        xButton.setSize(30, 27);
        xButton.setPosition(490, 350);
        xButton.addListener(new MessageEventListener() {
            @Override
            public void receivedMessage(int message, Actor actor) {
                if (actor != xButton || message != ToggleButtonListener.ON_TOUCH_UP ||
                            CountdownState.FINISHED == state) {
                    return;
                }
                RewardedVideoDialog.this.runtimeInfo.stateTracker.setState(StateTracker.GameState.OVER);
                state = CountdownState.EMPTY;
            }
        });

        // Film-reel countdown image.
        Texture filmReelCountdownIcon = assetController.get(Assets.FILM_REEL_COUNTDOWN_ICON);
        Image filmReelCountdownImage = new Image(filmReelCountdownIcon);
        filmReelCountdownImage.setPosition(360, 350);
        filmReelCountdownImage.setSize(53, 53);

        // Time label.
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = assetController.get(Assets.GAME_FONT);
        style.fontColor = Color.DARK_GRAY;
        this.timeLabel = new Label(Integer.toString((int)Math.ceil(this.timeLeft)), style);
        this.timeLabel.setFontScale(0.2f);
        this.timeLabel.setPosition(380, 355);

        setStage(viewport, batch, filmReelCountdownImage, rewardedReplayButton, xButton);
    }

    private void setStage(Viewport viewport, Batch batch,
                            Image filmReelCountdownImage,
                            ToggleButton rewardedReplayButton, ToggleButton xButton) {
        this.stage = new Stage(viewport, batch);
        this.stage.addActor(rewardedReplayButton);
        this.stage.addActor(xButton);
        this.stage.addActor(filmReelCountdownImage);
        this.stage.addActor(this.timeLabel);
        Gdx.input.setInputProcessor(this.stage);
    }

    public void update(float deltaTime) {
        switch (state) {
            case COUNTING:
                this.timeLeft -= deltaTime * COUNTDOWN_SPEED;
                if (this.timeLeft < 0) {
                    this.timeLeft = 0;
                    this.state = CountdownState.FINISHED;
                }
                this.timeLabel.setText(Integer.toString((int)Math.ceil(this.timeLeft)));
                break;
            case FINISHED:
                this.runtimeInfo.stateTracker.setState(StateTracker.GameState.OVER);
                break;
            case PLAYING_VIDEO:
                break;
            case EMPTY:
                break;
            default:
                break;
        }
    }

    private void playRewardingVideo() {
        this.state = CountdownState.PLAYING_VIDEO;
        this.adsController.showRewardingVideo(new Runnable() {
            @Override
            public void run() {
                runtimeInfo.gameLives = 3;
                runtimeInfo.stateTracker.setState(StateTracker.GameState.COUNTDOWN);
            }
        });
    }

    public void draw() {
        this.stage.draw();
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

}
