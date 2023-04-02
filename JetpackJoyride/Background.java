import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    int speedX;
    int increase;
    final int delay = 2;

    public void Background(){ 
        increase = 0;
    }

    public void act() 
    {
        speedX = (Zapper.velX + (MyWorld.getScore()/150));
        increase++;
        moveSpeed();
        respawn();
    }   

    public void moveSpeed(){
        if (!getWorld().getObjects(Barry.class).isEmpty()){
            if (increase >= delay){            
                setLocation(getX() - speedX, getY());
                increase = 0;
            }
        }
    } 

    public void respawn()
    {
        if (getX() <= -380){
            setLocation(1170, 150);
        }
    }
    
    public void setLocationB(int x, int y){
        setLocation(x, y);
    }
}
