import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{    
    int gifDelay;
    int delay;
    int increase;
    int timer;
    int currentImage;
    String[] images = {"Coin1.png", "Coin2.png", "Coin3.png", "Coin4.png", "Coin5.png"};
    boolean right = true;
    boolean isAlive = true;
    public Coin(){  
        currentImage = 0;
        increase = 0;
        timer = 0;
        gifDelay = 5;
        delay = 2;
    }

    public void act() 
    {
        animation();
        if (!getWorld().getObjects(Barry.class).isEmpty()){
            collect();
            moveSpeed();
            delete();
            increase++;
        }
    } 

    public void animation(){    
        timer++;
        if (timer >= gifDelay){
            timer = 0;
            if (currentImage >= images.length - 1){
                right = false;
            }
            else if (currentImage <= 1)
                right = true;
            if (right == true)
                currentImage++;
            else
                currentImage--;
            setImage(images[currentImage]);
        }
    }

    public void collect() 
    {      
        if (isTouching(Barry.class)){
            getWorld().removeObject(this);       
            MyWorld.setCoinCount(MyWorld.getCoinCount() + 1);
            isAlive = false;
            Greenfoot.playSound("coin.mp3");
        }
    } 

    public void moveSpeed(){        
        if (increase >= delay && isAlive == true){
            setLocation(getX() - ((Zapper.velX + (MyWorld.getScore()/150))), getY());
            increase = 0;
        }
    } 

    public void delete()
    {
        if (isAlive != false && getX() <= -70){
            getWorld().removeObject(this);
            isAlive = false;
        }
    }
}