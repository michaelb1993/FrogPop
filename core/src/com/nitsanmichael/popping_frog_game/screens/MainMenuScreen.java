package com.nitsanmichael.popping_frog_game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nitsanmichael.popping_frog_game.PoppingFrog;
import com.nitsanmichael.popping_frog_game.assets.Assets;
import com.nitsanmichael.popping_frog_game.sprites.Buttons;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleBritishFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleHealthFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleIllusionFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleMexicanFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleEvilFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleRegularFrog;
import com.nitsanmichael.popping_frog_game.sprites.frogs.idle.IdleTurkishFrog;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;


/**
 * Created by MichaelBond on 9/1/2016.
 */
public class MainMenuScreen extends FadingScreen {

    private static final float FADE_OUT_TIME = 1f;
    private static final float FADE_IN_TIME = 1f;
    private static final float GAME_FADE_IN = 0.3f;

    private Sprite End;
    private BitmapFont Score;
    private Buttons button1;
    private Buttons button2;
    private Buttons chooseHero;
    private PoppingFrog game;
    private Viewport viewport;
    private Array<IdleFrog> idleFrogs;
    private Texture playgame=new Texture("buttons/startgamen.png");
    private Texture pressedplaygame=new Texture("buttons/startgame2n.png");
    private Texture settings=new Texture("buttons/settings.png");
    private Texture pressedsettings=new Texture("buttons/settings2.png");
    private Texture chooseHeroIcon=new Texture("buttons/choosehero.png");
    private Texture pressedChooseHeroIcon=new Texture("buttons/choosehero2.png");


    public MainMenuScreen(PoppingFrog game) {
        super(game.batch, game.tweenController);
        this.viewport = new FitViewport(
                PoppingFrog.VIRTUAL_WIDTH, PoppingFrog.VIRTUAL_HEIGHT, new OrthographicCamera());
        if (game.adsController.isInternetConnected()) {
            game.adsController.showBannerAd();
        }
        this.game = game;
        this.Score = new BitmapFont(Gdx.files.internal("font.fnt"));
        End=new Sprite(new Texture(Gdx.files.internal("intro2.jpg")));
        button1=new Buttons(300,395,playgame,pressedplaygame);
        button2=new Buttons(300,315,settings,pressedsettings);
        chooseHero=new Buttons(300,235,chooseHeroIcon,pressedChooseHeroIcon);
        initIdleFrogs();
        // Play music.
        this.game.media.playMusic(Assets.MAIN_MENU_MUSIC);
        this.game.playServices.signIn();
    }

    private void initIdleFrogs() {
        this.idleFrogs = new Array<IdleFrog>();
//        idleFrogs.add(new IdleRegularFrog(this.game.assetController,
//                    IdleRegularFrog.AnimationType.TONGUE, new Vector2(415, 125)));
        idleFrogs.add(new IdleIllusionFrog(this.game.assetController, new Vector2(415, 125)));
        idleFrogs.add(new IdleRegularFrog(this.game.assetController,
                    IdleRegularFrog.AnimationType.WINK, new Vector2(255, 125)));
        idleFrogs.add(new IdleBritishFrog(this.game.assetController, new Vector2(340, 70)));
        idleFrogs.add(new IdleMexicanFrog(this.game.assetController, new Vector2(170, 180)));
        idleFrogs.add(new IdleTurkishFrog(this.game.assetController, new Vector2(500, 180)));
        idleFrogs.add(new IdleEvilFrog(this.game.assetController, new Vector2(50, 150)));
        idleFrogs.add(new IdleHealthFrog(this.game.assetController, new Vector2(620, 150)));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0/255f, 163/255f, 232/255f, 1);
        this.game.batch.setProjectionMatrix(viewport.getCamera().combined);
        this.game.batch.begin();
        End.draw(this.game.batch);
        drawGO();
        drawButtons();
        drawIdleFrogs();
        this.game.batch.end();
    }

    public void update(float deltaTime) {
        handleInput();
        updateIdleFrogs(deltaTime);
        this.viewport.getCamera().update();
    }

    private void updateIdleFrogs(float deltaTime) {
        for (IdleFrog frog : this.idleFrogs) {
            frog.update(deltaTime);
        }
    }

    public void handleInput() {
        Vector3 touches=viewport.unproject( new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
        Vector2 touchVector = new Vector2(touches.x,touches.y);
        if (this.button1.isButtonsTouched(touchVector)) {
            this.game.tweenController.fadeOutScreen(this, FADE_OUT_TIME, new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        FadingScreen screen = new PlayScreen(game);
                        game.setScreen(screen);
                        game.tweenController.fadeInScreen(screen, GAME_FADE_IN, null);
                    }
            });
        }
        if (this.button2.isButtonsTouched(touchVector)) {
            this.game.setScreen(new SettingsScreen(game, MainMenuScreen.this));
        }
        if (this.chooseHero.isButtonsTouched(touchVector)) {
            this.game.tweenController.fadeOutScreen(this, FADE_OUT_TIME, new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        FadingScreen screen = new ChooseHeroScreen(game);
                        game.setScreen(screen);
                        game.tweenController.fadeInScreen(screen, FADE_IN_TIME, null);
                    }
            });
        }
    }

    private void drawGO()
    {
        SpriteBatch batch = this.game.batch;
        Score.getData().setScale(0.2f);
        Score.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        Score.draw(batch, "Highest score: "+ this.game.data.getHighScore(),300,50);

    }

    private void drawButtons()
    {
        SpriteBatch batch = this.game.batch;
        Vector2 button1Position = this.button1.getPosition();
        Vector2 button2Position = this.button2.getPosition();
        batch.draw(this.button1.getButtonsTexture(), button1Position.x, button1Position.y);
        batch.draw(this.button2.getButtonsTexture(), button2Position.x, button2Position.y);
        batch.draw(this.chooseHero.getButtonsTexture(), chooseHero.getPosition().x, chooseHero.getPosition().y);
    }

    private void drawIdleFrogs() {
        for (IdleFrog frog : this.idleFrogs) {
            frog.draw(this.game.batch);
        }
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        End.getTexture().dispose();
    }

    @Override
    public void show() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

}
