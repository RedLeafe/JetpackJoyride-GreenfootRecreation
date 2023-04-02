import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends ReplayButton
{
    public void move(){
        setLocation(400, 150);
    }
    
    public void act() 
    {
        if (getWorld().getObjects(Barry.class).isEmpty()){
            move();
        }
        if (clicked == true){
            setLocation(1000, 1000);
        }
        if (isTouching(Zapper.class)){
            removeTouching(Zapper.class);            
        }        
        if (isTouching(Coin.class)){
            removeTouching(Coin.class);            
        }
    } 
}
