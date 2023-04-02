import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScreenButton extends Actor
{
    static boolean mainButtonClicked = false;

    public void move(){
        setLocation(320, 210);
    }
    
    public void act() 
    {
        if (getWorld().getObjects(Barry.class).isEmpty()){
            move();
        }
        if (Greenfoot.mouseClicked(this)) { 
            getWorld().removeObject(this);
            Greenfoot.setWorld(new MainScreen());
        }    
    }    
}
