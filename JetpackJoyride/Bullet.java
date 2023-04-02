import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int bulletTurn = (int)(Math.random() * 60) + 60;
    public Bullet(){        
        turn(bulletTurn);
    }

    public void act() 
    {
        move(15);
        delete();
    }    
    
    public void delete()
    {
        if (getY() >= 280){
            getWorld().removeObject(this);
        }
    }
}
