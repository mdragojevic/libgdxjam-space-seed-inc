package com.starseed.util;

import com.badlogic.gdx.math.Vector2;

public class Constants {
	
	public static final int APP_WIDTH = 1024;
	public static final int APP_HEIGHT = 768;
	public static final float WORLD_TO_SCREEN = 8;
	public static final Vector2 WORLD_GRAVITY = new Vector2( 0, 0 );
	
	public static final float RAD_TO_DEG = 180.0f / (float)Math.PI;
	
	/*
	 * Multiplayer game constants
	 */
	
	// Screen space
	// Top UI will take 1/8 of the screen
	public static final float GAME_UI_HEIGHT = 0f; //APP_WIDTH * 0.125f;	
		
	// Physics space
	// Multiplayer game space is 128 * 84 meters
	public static final float WORLD_WIDTH = APP_WIDTH / WORLD_TO_SCREEN;
	public static final float WORLD_HEIGHT = (APP_HEIGHT - GAME_UI_HEIGHT) / WORLD_TO_SCREEN;

	// Border around the game field
	public static final float EDGE_WIDTH = WORLD_WIDTH * 0.05f;
	public static final float EDGE_INNER_X_START = EDGE_WIDTH;
	public static final float EDGE_INNER_Y_START = EDGE_WIDTH;
	public static final float EDGE_INNER_X_END = WORLD_WIDTH - EDGE_WIDTH;
	public static final float EDGE_INNER_Y_END = WORLD_HEIGHT - EDGE_WIDTH;
	
	// Ship values
	public static final float SHIP_WIDTH = 8f;
	public static final float SHIP_HEIGHT = 8f; 	
	public static final float SHIP_DENSITY = 1.5f;
	
	public static final float SHIP_ANGULAR_IMPULSE = 80;
	public static final float SHIP_ANGULAR_DAMPING = 6f;
	public static final float SHIP_ENGINE_FORCE = 10000;
	public static final float SHIP_LINEAR_DAMPING = 1f;
	
	
	/*
	 * Texture file paths
	 */
	
	public static final String IMAGE_SHIP = "ship_player_1.png";
	
	
	/*
	 *  MartianRun tutorial constants
	 */
	
	public static final float GROUND_WIDTH = WORLD_WIDTH * 1.5f;
    public static final float GROUND_HEIGHT = WORLD_HEIGHT * 0.15f;
	public static final float GROUND_X = WORLD_WIDTH * 0.5f;
    public static final float GROUND_Y = GROUND_HEIGHT * 0.5f; 
    public static final float GROUND_TOP = GROUND_Y + GROUND_HEIGHT * 0.5f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_WIDTH = 1.5f;
    public static final float RUNNER_HEIGHT = 3f;  
    public static final float RUNNER_X = WORLD_WIDTH * 0.1f;
    public static final float RUNNER_Y = GROUND_TOP + RUNNER_HEIGHT * 0.5f;  
    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_DODGE_HEIGHT = RUNNER_WIDTH * 0.5f;
    public static final float RUNNER_DODGE_X = RUNNER_X;
    public static final float RUNNER_DODGE_Y = RUNNER_Y - RUNNER_DODGE_HEIGHT;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, RUNNER_HEIGHT * RUNNER_WIDTH * 9f);
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;

    public static final float ENEMY_X = WORLD_WIDTH + 2;
    public static final float ENEMY_DENSITY = RUNNER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = GROUND_TOP;
    public static final float RUNNING_LONG_ENEMY_Y = GROUND_TOP;
    public static final float FLYING_ENEMY_Y = RUNNER_Y + RUNNER_DODGE_HEIGHT + 0.5f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);
    
    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    
    public static final String CHARACTERS_ATLAS_PATH = "characters.atlas";
    public static final String[] RUNNER_RUNNING_REGION_NAMES = new String[] {"alienGreen_run1", "alienGreen_run2"};
    public static final String RUNNER_DODGING_REGION_NAME = "alienGreen_dodge";
    public static final String RUNNER_HIT_REGION_NAME = "alienGreen_hit";
    public static final String RUNNER_JUMPING_REGION_NAME = "alienGreen_jump";
    
    public static final String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"ladyBug_walk1", "ladyBug_walk2"};
    public static final String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"barnacle_bite1", "barnacle_bite2"};
    public static final String[] RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"spider_walk1", "spider_walk2"};
    public static final String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"worm_walk1", "worm_walk2"};
    public static final String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"bee_fly1", "bee_fly2"};
    public static final String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly_fly1", "fly_fly2"};



}
