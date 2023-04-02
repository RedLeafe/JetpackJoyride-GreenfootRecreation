import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScreen extends World
{
    
    public MainScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 300, 1, false); 
        placeBackground(800, 380, 400, 150);
    }

    public void placeBackground(int scaleX, int scaleY, int X, int Y){
        HomeBackground bk = new HomeBackground();
        GreenfootImage back = bk.getImage();  
        back.scale(scaleX, scaleY);
        bk.setImage(back);
        Icon i = new Icon();
        GreenfootImage icon = i.getImage();  
        icon.scale(scaleX - 400, scaleY - 200);
        i.setImage(icon);
        StartingBarry b = new StartingBarry();
        addObject(bk, X, Y);        
        Explosion e = new Explosion();
        addObject(bk, X, Y);
        addObject(i, X, Y);
        addObject(b, -20, 275);
        addObject(e, 0, -200);
        showText("Press Space to Play",390,240);
    }
}
