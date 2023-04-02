import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReplayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReplayButton extends Actor
{
    public static boolean clicked = false;

    public void move(){
        setLocation(455, 210);
    }

    public void act() 
    {
        if (getWorld().getObjects(Barry.class).isEmpty()){
            move();
        }
        if (Greenfoot.mouseClicked(this)) { 
            Greenfoot.setWorld(new BarryIntro());
            getWorld().removeObject(this);
        }    
    }

    public static boolean getClicked(){
        return clicked;
    }

    public static void setClicked(boolean b){
        clicked = b;
    }
}
