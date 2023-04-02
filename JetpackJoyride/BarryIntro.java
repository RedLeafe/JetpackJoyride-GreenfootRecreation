import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarryIntro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarryIntro extends World
{

    /**
     * Constructor for objects of class BarryIntro.
     * 
     */
    public BarryIntro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 300, 1, false); 
        HomeBackground bk = new HomeBackground();
        GreenfootImage back = bk.getImage();  
        back.scale(800, 380);
        bk.setImage(back);
        addObject(bk, 400, 150); 
        StartingBarry b = new StartingBarry();
        addObject(b, -20, 275);
        Explosion e = new Explosion();
        addObject(e, 0, -200);
        HomeBackground.homeClicked = true;
    }
}
