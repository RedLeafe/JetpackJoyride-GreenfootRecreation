import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Obstacles
{
    int speedX;
    int delay;
    int gifDelay;
    int timer;
    int increase;
    int currentImage;
    String[] images = {"rocket1.png", "rocket2.png", "rocket3.png"};
    public Rocket(){  
        turn(-90);
        delay = 2;
        gifDelay = 10;
        timer = 0;
        currentImage = 0;
        increase = 0; 
        speedX = ((Zapper.velX + (MyWorld.getScore()/150)) * 3);
    }

    public void act() 
    {
        moveSpeed();
        kill();
        delete();
        animation();
    }    

    public void moveSpeed(){
        increase++;
        if (increase >= delay){
            setLocation(getX() - speedX, getY());
            increase = 0;
        }
    } 

    public void animation(){
        timer++;
        if (timer >= gifDelay){
            timer = 0;
            currentImage++;
            if (currentImage >= images.length){
                currentImage = 0;
            }
            setImage(images[currentImage]);
        }
    }
}
