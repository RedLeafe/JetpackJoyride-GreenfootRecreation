
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeBackground extends Actor
{
    public static boolean homeClicked = false;
    int timer = 0;
    int delay = 105;
    int increase = 0;
    public static GreenfootSound backgroundMusic = new GreenfootSound("Jetpack_Joyride_Main_Theme_(getmp3.pro).mp3");
    public static GreenfootSound backgroundMusic1 = new GreenfootSound("Jetpack_Joyride_OST_-_The_Stash_(getmp3.pro).mp3");

    public void act() 
    {        
        backgroundMusic1.playLoop();
        backgroundMusic.stop();
        if (Greenfoot.isKeyDown("space")){   
            homeClicked = true;
            getWorld().removeObjects(getWorld().getObjects(Icon.class));
        }  
        if (homeClicked == true){
            backgroundMusic1.stop();
            getWorld().showText("",390,240);
            if (timer >= delay){
                Greenfoot.setWorld(new MyWorld());
                homeClicked = false;
                backgroundMusic.playLoop();
                Explosion.Explosion.stop();
            }
            timer++;
        }  
    } 
}
