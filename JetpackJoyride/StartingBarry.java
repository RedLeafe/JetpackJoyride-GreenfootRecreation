import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartingBarry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartingBarry extends Actor
{
    String[] images = {"Barry1.png", "Barry2.png"};    
    int timer;
    int gifDelay;
    int currentImage;
    public StartingBarry(){
        timer = 0;
        gifDelay = 20;
        currentImage = 0;
    }
    
    public void act() 
    {
        animationRunning();
        if (HomeBackground.homeClicked == true){
            setLocation(getX() + 3, getY());
        }
    }   
    
    public void animationRunning(){
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
