package com.starseed.util;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.starseed.box2d.UserData;
import com.starseed.enums.UserDataType;

public class BodyUtils {
	
	private static Rectangle gameRect = new Rectangle(
    		-Constants.WORLD_HALF_WIDTH, 
    		-Constants.WORLD_HALF_HEIGHT, 
    		Constants.WORLD_WIDTH * 2f,
    		Constants.WORLD_HEIGHT * 2f);
	
	public static boolean bodyInBounds(Body body) {
        UserDataType type = bodyType(body);
        switch (type) {
        	case SEED:
        	case ASTEROID:
        	case RUNNER:
        		return gameRect.contains( body.getPosition() );
        		        		
        	case GROUND:
            default:
            		break;
        }

        return true;
    }
	
	public static boolean bodiesAreOfTypes( Body first, Body second, UserDataType typeOne, UserDataType typeTwo )
	{
		UserDataType typeFirst = bodyType(first);
		UserDataType typeSecond = bodyType(second);

        return (typeFirst == typeOne && typeSecond == typeTwo) || (typeFirst == typeTwo && typeSecond == typeOne);		
	}
	
	public static boolean bodiesAreOfType( Body first, Body second, UserDataType type )
	{
		return bodiesAreOfTypes(first, second, type, type);
	}

    public static boolean bodyIsOfType(Body body, UserDataType type) {
         return bodyType(body) == type;
    }
    
    public static UserDataType bodyType( Body body )
    {
    	UserData userData = (UserData) body.getUserData();
        return userData != null ? userData.getUserDataType(): UserDataType.NONE; 
    }
    
}