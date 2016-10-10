package com.nitsanmichael.popping_frog_game.assets;

/**
 * Created by MichaelBond on 10/6/2016.
 */
public final class Assets {

    /**
     * Media.
     */
    // Music.
    public static final String GAME_PLAY_MUSIC = "media/music.ogg";
    // Sound.
    public static final String LEVEL_UP_SOUND = "media/level_up.wav";
    public static final String GAME_OVER_SOUND = "media/game_over.mp3";
    public static final String MAIN_MENU_MUSIC = "media/main.ogg";

    public static final String MUSIC_FILES [] = {
            GAME_PLAY_MUSIC,
            MAIN_MENU_MUSIC
    };
    public static final String SOUND_FILES [] = {
            LEVEL_UP_SOUND,
            GAME_OVER_SOUND
    };

    /**
     * Fonts.
     */
    public static final String GAME_FONT = "font/font.fnt";

    public static final String FONT_FILES [] = {
            GAME_FONT
    };

    /**
     * Skins.
     */
    public static final String SLIDER_SKIN = "skin/uiskin.json";

    public static final String SKIN_FILES [] = {
            SLIDER_SKIN
    };

    /**
     * Effects.
     */
    public static class EffectMeta {
        public String name;
        public String fileName;
        public String dirName;

        public EffectMeta(String name, String fileName, String dirName) {
            this.name = name;
            this.fileName = fileName;
            this.dirName = dirName;
        }
    }
    // Rain effect.
    public static final EffectMeta RAIN_EFFECT =
                new EffectMeta("rain", "effects/rain/rain_effect", "effects/rain/");
    // Snow effect.
    public static final EffectMeta SNOW_EFFECT =
            new EffectMeta("snow", "effects/snow/snow_effect", "effects/snow/");
    // Sun effect.
    public static final EffectMeta SUN_EFFECT =
            new EffectMeta("sun", "effects/sun/sun_effect", "effects/sun/");

    public static final EffectMeta PARTICLE_EFFECTS [] = {
            RAIN_EFFECT,
            SNOW_EFFECT,
            SUN_EFFECT
    };

    /**
     * Textures.
     */
    // Icons.
    public static final String RETURN_ICON = "icons/back_icon.png";
    // Themes.
    public static final String SUMMER_THEME = "images/themes/summer.png";
    public static final String AUTUMN_THEME = "images/themes/autumn.png";
    public static final String WINTER_THEME = "images/themes/winter.png";
    public static final String SPRING_THEME = "images/themes/spring.png";
    // Sprites.
    public static final String TIMER = "images/timer/timer.png";
    public static final String TIMER_HAND = "images/timer/hand.png";
    public static final String CLOUD = "images/cloud.png";
    public static final String HOLE = "images/hole.png";
    // Butterflies.
    public static final String BUTTERFLY_ORANGE = "images/butterflies/orange.png";
    public static final String BUTTERFLY_PURPLE = "images/butterflies/purple.png";
    public static final String BUTTERFLY_RED = "images/butterflies/red.png";
    // Bird textures.
    public static final String BIRD1 = "images/bird/bird1.png";
    public static final String BIRD2 = "images/bird/bird2.png";
    public static final String BIRD3 = "images/bird/bird3.png";

    // Ghost.
    public static final String FROG_GHOST = "images/ghost.png";
    // Health frog.
    public static final String HEALTH_FROG1 = "images/frogs/health/frog1.png";
    public static final String HEALTH_FROG2 = "images/frogs/health/frog2.png";
    // Evil frog.
    public static final String EVIL_FROG1 = "images/frogs/evil/frog1.png";
    public static final String EVIL_FROG2 = "images/frogs/evil/frog2.png";
    public static final String EVIL_FROG3 = "images/frogs/evil/frog3.png";
    // Freeze frog.
    public static final String FREEZE_FROG1 = "images/frogs/freeze/frog1.png";
    public static final String FREEZE_FROG2 = "images/frogs/freeze/frog2.png";
    public static final String FREEZE_FROG3 = "images/frogs/freeze/frog3.png";
    // Big freeze frog.
    public static final String FREEZE_FROG_BIG1 = "images/frogs/freeze/big/frog1.png";
    public static final String FREEZE_FROG_BIG2 = "images/frogs/freeze/big/frog2.png";
    public static final String FREEZE_FROG_BIG3 = "images/frogs/freeze/big/frog3.png";
    // Illusion frog.
    public static final String ILLUSION_FROG1 = "images/frogs/illusion/frog1.png";
    public static final String ILLUSION_FROG2 = "images/frogs/illusion/frog2.png";
    public static final String ILLUSION_FROG3 = "images/frogs/illusion/frog3.png";
    public static final String ILLUSION_FROG4 = "images/frogs/illusion/frog4.png";
    // Regular hero.
    public static final String HERO_REGULAR_TONGUE1 = "images/frogs/hero/regular/tongue1.png";
    public static final String HERO_REGULAR_TONGUE2 = "images/frogs/hero/regular/tongue2.png";
    public static final String HERO_REGULAR_TONGUE3 = "images/frogs/hero/regular/tongue3.png";
    public static final String HERO_REGULAR_TONGUE4 = "images/frogs/hero/regular/tongue4.png";
    public static final String HERO_REGULAR_WINK1 = "images/frogs/hero/regular/wink1.png";
    public static final String HERO_REGULAR_WINK2 = "images/frogs/hero/regular/wink2.png";
    public static final String HERO_REGULAR_WINK3 = "images/frogs/hero/regular/wink3.png";
    public static final String HERO_REGULAR_WINK4 = "images/frogs/hero/regular/wink4.png";
    // Turkish hero.
    public static final String HERO_TURKISH1 = "images/frogs/hero/turkish/frog1.png";
    public static final String HERO_TURKISH2 = "images/frogs/hero/turkish/frog2.png";
    public static final String HERO_TURKISH3 = "images/frogs/hero/turkish/frog3.png";
    // Mexican hero.
    public static final String HERO_MEXICAN1 = "images/frogs/hero/mexican/frog1.png";
    public static final String HERO_MEXICAN2 = "images/frogs/hero/mexican/frog2.png";
    // British hero.
    public static final String HERO_BRITISH1 = "images/frogs/hero/british/frog1.png";
    public static final String HERO_BRITISH2 = "images/frogs/hero/british/frog2.png";
    public static final String HERO_BRITISH3 = "images/frogs/hero/british/frog3.png";

    public static final String TEXTURE_FILES [] = {
        // Icons
            RETURN_ICON,
        // Themes
            SUMMER_THEME,
            AUTUMN_THEME,
            WINTER_THEME,
            SPRING_THEME,
        // Sprites
            TIMER,
            TIMER_HAND,
            CLOUD,
            HOLE,
            BUTTERFLY_ORANGE,
            BUTTERFLY_PURPLE,
            BUTTERFLY_RED,
            FROG_GHOST,
        // CAnimation textures
            BIRD1, BIRD2, BIRD3,    // Bird
            HEALTH_FROG1, HEALTH_FROG2, // Health frog
            EVIL_FROG1, EVIL_FROG2, EVIL_FROG3, // Evil frog
            FREEZE_FROG1, FREEZE_FROG2, FREEZE_FROG3,   // Freeze frog
            FREEZE_FROG_BIG1, FREEZE_FROG_BIG2, FREEZE_FROG_BIG3,   // Big freeze frog
            ILLUSION_FROG1, ILLUSION_FROG2, ILLUSION_FROG3, ILLUSION_FROG4, // Illusion frog
            HERO_REGULAR_TONGUE1, HERO_REGULAR_TONGUE2, HERO_REGULAR_TONGUE3, HERO_REGULAR_TONGUE4,
            HERO_REGULAR_WINK1, HERO_REGULAR_WINK2, HERO_REGULAR_WINK3, HERO_REGULAR_WINK4,
            HERO_TURKISH1, HERO_TURKISH2, HERO_TURKISH3,    // Turkish hero
            HERO_MEXICAN1, HERO_MEXICAN2,   // Mexican hero
            HERO_BRITISH1, HERO_BRITISH2, HERO_BRITISH3 // British hero
    };


    /**
     * Animations textures.
     */
    public static final String BIRD_ANIMATION [] = {
            BIRD1,
            BIRD2,
            BIRD3,
            BIRD3,
            BIRD2,
            BIRD1
    };
    public static final String HEALTH_FROG_ANIMATION [] = {
            HEALTH_FROG1,
            HEALTH_FROG2
    };
    public static final String EVIL_FROG_ANIMATION [] = {
            EVIL_FROG1,
            EVIL_FROG2,
            EVIL_FROG3
    };
    public static final String FREEZE_FROG_ANIMATION [] = {
            FREEZE_FROG1,
            FREEZE_FROG2,
            FREEZE_FROG3,
            FREEZE_FROG3,
            FREEZE_FROG3,
            FREEZE_FROG2,
            FREEZE_FROG1
    };
    public static final String FREEZE_FROG_BIG_ANIMATION [] = {
            FREEZE_FROG_BIG1,
            FREEZE_FROG_BIG2,
            FREEZE_FROG_BIG3,
            FREEZE_FROG_BIG3,
            FREEZE_FROG_BIG2,
            FREEZE_FROG_BIG1
    };
    public static final String ILLUSION_FROG_ANIMATION [] = {
            ILLUSION_FROG1,
            ILLUSION_FROG2,
            ILLUSION_FROG3,
            ILLUSION_FROG4
    };
    public static final String HERO_REGULAR_TONGUE_ANIMATION [] = {
            HERO_REGULAR_TONGUE1,
            HERO_REGULAR_TONGUE2,
            HERO_REGULAR_TONGUE3,
            HERO_REGULAR_TONGUE4,
            HERO_REGULAR_TONGUE4,
            HERO_REGULAR_TONGUE3,
            HERO_REGULAR_TONGUE2,
            HERO_REGULAR_TONGUE1
    };
    public static final String HERO_REGULAR_WINK_ANIMATION [] = {
            HERO_REGULAR_WINK1,
            HERO_REGULAR_WINK2,
            HERO_REGULAR_WINK3,
            HERO_REGULAR_WINK4,
            HERO_REGULAR_WINK4,
            HERO_REGULAR_WINK3,
            HERO_REGULAR_WINK2,
            HERO_REGULAR_WINK1
    };
    public static final String HERO_TURKISH_ANIMATION [] = {
            HERO_TURKISH1,
            HERO_TURKISH2,
            HERO_TURKISH3,
            HERO_TURKISH2,
            HERO_TURKISH3,
            HERO_TURKISH2,
            HERO_TURKISH1
    };
    public static final String HERO_MEXICAN_ANIMATION [] = {
            HERO_MEXICAN1,
            HERO_MEXICAN2,
            HERO_MEXICAN1,
            HERO_MEXICAN2,
            HERO_MEXICAN2,
            HERO_MEXICAN1
    };
    public static final String HERO_BRITISH_ANIMATION [] = {
            HERO_BRITISH1,
            HERO_BRITISH2,
            HERO_BRITISH3,
            HERO_BRITISH2,
            HERO_BRITISH3,
            HERO_BRITISH2,
            HERO_BRITISH1
    };

}
