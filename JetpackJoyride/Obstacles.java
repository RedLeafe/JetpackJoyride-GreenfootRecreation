import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Obstacles extends Collision
{
    public void kill() 
    {      
        if (isTouching(Barry.class)){
            removeTouching(Barry.class);            
        }
    }    
    
    public void delete()
    {
        if (getX() <= -70){
            getWorld().removeObject(this);
        }
    }
    
    public abstract void moveSpeed();
}
