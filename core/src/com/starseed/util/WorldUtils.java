package com.starseed.util;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.starseed.box2d.*;
import com.starseed.enums.AsteroidType;
import com.starseed.enums.EdgeSideType;

public class WorldUtils {
	
	public static World createWorld() {
		return new World(Constants.WORLD_GRAVITY, true);
	}
	
	public static Body createEdge( World world, EdgeSideType type )
	{
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set( new Vector2( type.getXCenter(), type.getYCenter() ) );
				
		PolygonShape shape = new PolygonShape();
		shape.setAsBox( type.getWidth() / 2, type.getHeight() / 2);
		
		Body body = world.createBody( bodyDef );
		body.createFixture( shape, type.getDensity() );
		body.setUserData( new EdgeUserData( type.getWidth(), type.getHeight() ) );
		
		shape.dispose();
		return body;
	}
	
	public static Body createPlayerShip(World world, Vector2 position, float angle) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
        bodyDef.angle = angle;
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.SHIP_WIDTH / 2, Constants.SHIP_HEIGHT / 2);
        Vector2[] triangle = new Vector2[] { 
        		new Vector2( -Constants.SHIP_WIDTH * 0.3f, -Constants.SHIP_HEIGHT * 0.41f ), 
        		new Vector2(  Constants.SHIP_WIDTH * 0.3f, -Constants.SHIP_HEIGHT * 0.41f ),
        		new Vector2(  Constants.SHIP_WIDTH * 0.05f, Constants.SHIP_HEIGHT * 0.47f ),
        		new Vector2( -Constants.SHIP_WIDTH * 0.05f, Constants.SHIP_HEIGHT * 0.47f ) };
        shape.set( triangle );
        
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, Constants.SHIP_DENSITY);
        body.resetMassData();
        body.setUserData(new ShipUserData( Constants.SHIP_WIDTH, Constants.SHIP_WIDTH ));
        body.setAngularDamping(Constants.SHIP_ANGULAR_DAMPING);
        body.setLinearDamping(Constants.SHIP_LINEAR_DAMPING);
        
        shape.dispose();
        return body;
    }
	
	private static float angle = 0;
	public static Body createAsteroid(World world, AsteroidType aType, Vector2 position) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
       
        bodyDef.angle = angle;
        angle += Math.PI * 0.5f;
        
        CircleShape shape = new CircleShape();
        shape.setRadius(aType.getRadius());
                
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, Constants.ASTEROID_DENSITY);
        body.resetMassData();
        body.setUserData(new AsteroidUserData( aType.getRadius() * 2, aType.getRadius() * 2, aType ));
        body.setAngularVelocity( RandomUtils.rangeFloat(-2.5f, 2.5f) );
        shape.dispose();
        return body;
    }
		
	public static Body createRunner(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2( RandomUtils.nextFloat() * Constants.WORLD_WIDTH, RandomUtils.nextFloat() * Constants.WORLD_HEIGHT));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.RUNNER_WIDTH / 2, Constants.RUNNER_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, Constants.RUNNER_DENSITY);
        body.resetMassData();
        body.setAngularVelocity( RandomUtils.rangeFloat(-2.5f, 2.5f) );
        body.setUserData(new RunnerUserData( Constants.RUNNER_WIDTH, Constants.RUNNER_HEIGHT ));
        shape.dispose();
        return body;
    }
	
	public static Body createSeed(World world, Vector2 position, Vector2 direction, int playerIndex) {
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(position);
				
		CircleShape shape = new CircleShape();
		shape.setRadius( Constants.SEED_RADIUS );
		
		Body body = world.createBody(bodyDef);
		body.createFixture(shape, Constants.SEED_DENSITY);
		body.resetMassData();
		body.setUserData( new ProjectileUserData( Constants.SEED_RADIUS * 2f, Constants.SEED_RADIUS * 2f, playerIndex, true ));
		
		Vector2 exitSpeed = new Vector2(direction);
		exitSpeed.scl( Constants.SEED_SPEED );
		body.setLinearVelocity( exitSpeed );
		
		shape.dispose();		
		return body;
	}
	
	public static Body createLaser(World world, Vector2 position, Vector2 direction, int playerIndex) {
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(position);
		bodyDef.angle = direction.angleRad();
				
		PolygonShape shape = new PolygonShape();
		shape.setAsBox( Constants.LASER_WIDTH * 0.5f, Constants.LASER_HEIGHT * 0.5f);
		
		Body body = world.createBody(bodyDef);
		body.createFixture(shape, Constants.LASER_DENSITY);
		body.resetMassData();
		body.setUserData( new ProjectileUserData( Constants.LASER_WIDTH, Constants.LASER_HEIGHT, playerIndex, false ));
		
		Vector2 exitSpeed = new Vector2(direction);
		exitSpeed.scl( Constants.LASER_SPEED );
		body.setLinearVelocity( exitSpeed );
		
		shape.dispose();		
		return body;
	}
	
}
