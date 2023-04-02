import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zapper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zapper extends Obstacles
{
    public static int velX;
    int delay;
    int increase;    
    int gifTimer;
    int gifDelay;
    int currentImage;
    int originalX = 700;
    int summon;
    int m = (int)(Math.random() * 12) + 1;
    String[] images = {"Zapper1.png", "Zapper2.png", "Zapper3.png"};
    public Zapper(){ 
        velX = 4;
        delay = 2;
        increase = 0;   
        gifDelay = 7;
        gifTimer = 0; 
        if (m < 3)
            turn(45);
        else if (m >= 3 && m < 6)
            turn(-45);
        else if (m >= 6 && m < 9){
            turn(90); 
        }
    }

    public void act() 
    {     
        animation();
        if (!getWorld().getObjects(Barry.class).isEmpty()){
            summon = (int)(Math.random() * 50);
            increase++;
            moveSpeed();
            kill();
            delete();
        }
    }  
    
    public void kill() 
    {      
        if (isTouching(Barry.class)){
            removeTouching(Barry.class);    
            Greenfoot.playSound("ZapperDeath.mp3");
        }
    }    

    public void moveSpeed(){
        if (increase >= delay){
            setLocation(getX() - ((velX + (MyWorld.getScore()/150))), getY());
            increase = 0;
        }
    } 
    
    public void animation(){
        gifTimer++;
        if (gifTimer >= gifDelay){
            gifTimer = 0;
            currentImage++;
            if (currentImage >= images.length){
                currentImage = 0;
            }
            setImage(images[currentImage]);
        }
    }
}
