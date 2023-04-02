import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    int increase = 0;
    int gifDelay = 8;
    int currentImage = 0;
    String[] images = {"frame_00_delay-0.08s.gif", "frame_01_delay-0.08s.gif", "frame_02_delay-0.08s.gif", "frame_03_delay-0.08s.gif", "frame_04_delay-0.08s.gif", "frame_05_delay-0.08s.gif", "frame_06_delay-0.08s.gif", "frame_07_delay-0.08s.gif", "frame_08_delay-0.08s.gif"};    
    public static GreenfootSound Explosion = new GreenfootSound("Explosion.mp3");
    public void act() 
    {
        if (HomeBackground.homeClicked == true){
            setLocation(0, 250);
            animation();
            Explosion.play();
        }
    }    

    public void animation(){
        increase++;
        if (increase >= gifDelay){
            if (currentImage < images.length - 1){
                increase = 0;
                currentImage++;
                setImage(images[currentImage]);
            }
            else
                getWorld().removeObject(this);
        }
    }
}
