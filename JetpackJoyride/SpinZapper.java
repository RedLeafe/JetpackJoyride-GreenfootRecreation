import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpinZapper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpinZapper extends Zapper
{
    boolean once = true;   
    public void act() 
    {
        animation();
        turn(2);
        if (!getWorld().getObjects(Barry.class).isEmpty()){
            increase++;
            moveSpeed();
            kill();
            delete();            
        }
    }  
}
